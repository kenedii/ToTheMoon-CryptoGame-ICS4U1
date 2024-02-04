import java.util.*;
import hsa.Console;
import java.io.*;
import java.awt.*;

/*
		      To The Moon
	    A Crypto and Stocks Investing Game
		   by: Chris Kenedi
	      ICS4U1 Culminating 2022-06-15
			   *     .--.
				/ /  `
	       +               | |
		      '         \ \__,
		  *          +   '--'  *
		      +   /\
	 +              .'  '.   *
		*      /======\      +
		      ;:.  _   ;
		      |:. (_)  |
		      |:.  _   |
	    +         |:. (_)  |          *
		      ;:.      ;
		    .' \:.    / `.
		   / .-'':._.'`-. \
		   |/    /||\    \|
		 _..--"""````"""--.._
	   _.-'``                    ``'-._
	 -'                                '-
*/


// The "ToTheMoon" class.
public class ToTheMoon
{

    protected static Console c;
    protected static Turtle t;

    public static void main (String[] args) throws IOException
    {
	c = new Console (28, 84);
	t = new Turtle (c);


	PriceCharts _prices = new PriceCharts (); // Generates the initial prices for each asset by creating an AssetPrices object
	PlayerAssets _player = new PlayerAssets (); // Creates the user's profile

	// Not sure why I need this but several things give NullPointerException without it. ////
	Date date = new Date ();                                                       /////////
	_player.setInfo ("date", date);                                                ////////
	//////////////////////////////////////////////////////////////////////////////////////

	boolean loaded = loadGame (_player, _prices); // Allows the user to load previous game from .MONEY file. Returns false if they did not load from file.

	if (loaded == true)
	{
	}
	else
	{
	    createGame (_player); // createGame method gets initial info from the player and stores it in the PlayerAssets object
	}

	_prices.printPrices (); // Displays prices of every asset on start.
	playerAction (_player, _prices); // Launches menu for player to select what they want to do.


    } // main method


    public static void playerAction (PlayerAssets _player, PriceCharts _prices) throws IOException // Menu for player to select what they want to do
    {
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	while (true)
	{
	    System.out.println ("Choose what you would like to do." + "\nYour Money: $" + _player.getBalances () [0]);
	    System.out.println ("1. Buy assets\n2. Sell assets\n3. End turn\n4. View Price Chart\n5. View Portfolio \n6. View Prices\n7.Save Game\n8. Skip Days");
	    String choice = br.readLine ();
	    if (choice.equals ("1") == true) // Buy assets
	    {
		buyAsset (_player, _prices);
	    }
	    else if (choice.equals ("2") == true) // Sell assets
	    {
		sellAsset (_player, _prices);
	    }

	    else if (choice.equals ("3") == true)
	    { //End turn
		_player.setInfo ("timeplayed", (_player.getBalances () [11]) + 1);
		_prices.updatePrices (1);
	    }

	    else if (choice.equals ("4") == true)
	    { //View Price Chart
		generateChartMenu (_prices);
	    }

	    else if (choice.equals ("5") == true)
	    { // View portfolio
		printPortfolio (_player, _prices);
	    }

	    else if (choice.equals ("6") == true)
	    { //View prices
		_prices.printPrices ();
	    }

	    else if (choice.equals ("7") == true)
	    { //Save game
		saveGame (_player, _prices);
	    }

	    else if (choice.equals ("8") == true)
	    { // Skip days
		System.out.print ("How many days would you like to skip? ");
		int _skip = Integer.parseInt (br.readLine ());
		_player.setInfo ("timeplayed", (_player.getBalances () [11]) + _skip);
		_prices.updatePrices (_skip);
	    }
	    else
	    {
		System.out.println ();
		System.out.println ("Invalid option. Please enter a number.");
		System.out.println ();
	    }

	}
    }


    public static void createGame (PlayerAssets _player) throws IOException // Gets name from user at start of game (if they did not load game from file)
    {
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	System.out.print ("Enter your name: ");
	String _name = br.readLine ();
	_player.setInfo ("name", _name);
	System.out.println ("OBJECTIVE: Pick the stocks and crypto you think will make you the most money.\nManage your portfolio and watch the price go to the moon!");
	System.out.println ("Press Enter to begin.");
	br.readLine ();
	for (int i = 0 ; i < 25 ; i++)
	{
	    System.out.println ("");
	}
    }


    // Menu Options

    public static void sellAsset (PlayerAssets _player, PriceCharts _prices) throws IOException
    {
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

	System.out.println ("Enter the ticker of the asset you want to sell:\nWMT    IBM     TSLA    AAPL    UBER\nBTC   ETH     DOGE    APE    XMR");
	String _asset = br.readLine ();
	_asset = _asset.toLowerCase ();
	int _assetNumber = StrToAssetNum (_asset); //Converts the string of the stock ticker to the position in the array that asset is in
	if (_assetNumber == 99)
	{

	}
	else
	{
	    System.out.println ("Enter how much of the asset you would like to sell (-1 for max)");
	    double _amount = Double.parseDouble (br.readLine ());


	    if (_player.getBalances () [_assetNumber + 1] < _amount)
	    {
		System.out.println ("You do not have enough of this asset to sell.");
	    }

	    else if (_amount == -1) // Sells all of the asset the player owns
	    {
		_amount = _player.getBalances () [_assetNumber + 1];
		_player.setInfo (_asset, 0);
		_player.setInfo ("money", (_player.getBalances () [0]) + (_amount * _prices.getPrices () [_assetNumber]));
	    }

	    else if (_amount < -1)
	    { // This fixes a glitch that used to allow you to sell negative assets to get into debt

	    }

	    else
	    {
		_player.setInfo (_asset, _player.getBalances () [_assetNumber + 1] - _amount);
		_player.setInfo ("money", (_player.getBalances () [0]) + (_amount * _prices.getPrices () [_assetNumber]));

	    }
	}
    }


    public static void buyAsset (PlayerAssets _player, PriceCharts _prices) throws IOException
    {
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

	System.out.println ("Enter the ticker of the asset you want to buy:\nWMT    IBM     TSLA    AAPL    UBER\nBTC   ETH     DOGE    APE    XMR");
	String _asset = br.readLine ();
	_asset = _asset.toLowerCase ();
	int _assetNumber = StrToAssetNum (_asset);
	if (_assetNumber == 99)
	{

	}
	else
	{

	    System.out.println ("Enter how much $ of the asset you would like to buy (-1 for max)");
	    System.out.print ("$");
	    double _amount = Double.parseDouble (br.readLine ());

	    if (_player.getBalances () [0] < _amount)
	    {
		System.out.println ("You do not have enough money to place this buy order.");
	    }

	    else if (_amount == -1) // Spend all remaining money on buy order
	    {
		_amount = _player.getBalances () [0];
		_player.setInfo (_asset, (_amount / _prices.getPrices () [_assetNumber]));
		_player.setInfo ("money", (0));
	    }

	    else if (_amount < -1)
	    { // This fixes a glitch that used to allow you to buy negative assets to create unlimited money

	    }

	    else
	    {
		double _amount1 = _amount / _prices.getPrices () [_assetNumber];
		_player.setInfo (_asset, _amount1);
		_player.setInfo ("money", (_player.getBalances () [0]) - (_amount));
	    }
	}
    }


    public static void generateChartMenu (PriceCharts _prices) throws IOException // Asks player which price chart they would like to view
    {
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

	System.out.println ("Enter the ticker of the asset you want to view the chart for:\nWMT    IBM     TSLA    AAPL    UBER\nBTC   ETH     DOGE    APE    XMR");
	String _asset = br.readLine ();
	_asset = _asset.toLowerCase ();
	int _assetNumber = StrToAssetNum (_asset);
	if (_assetNumber == 99)
	{

	}
	else
	{
	    _prices.generateChart (_assetNumber);
	}
    }


    public static void printPortfolio (PlayerAssets _player, PriceCharts _prices)  // Shows all the player's info
    {
	c.clear ();
	c.println ("Name: " + _player.getName () +
		"\nDate created: " + _player.getDate ().toString () +
		"\nMoney: $" + _player.getBalances () [0] +
		"\nTotal Value of Assets: $" + (double) Math.round (((_player.getBalances () [1] * _prices.getPrices () [0]) + (_player.getBalances () [2] * _prices.getPrices () [1]) + (_player.getBalances () [3] * _prices.getPrices () [2]) + (_player.getBalances () [4] * _prices.getPrices () [3]) + (_player.getBalances () [5] * _prices.getPrices () [4]) + (_player.getBalances () [6] * _prices.getPrices () [5]) + (_player.getBalances () [7] * _prices.getPrices () [6]) + (_player.getBalances () [8] * _prices.getPrices () [7]) + (_player.getBalances () [9] * _prices.getPrices () [8]) + (_player.getBalances () [10] * _prices.getPrices () [9])) * 10000) / 10000 +
		"\nWMT: " + _player.getBalances () [1] + " x $" + (double) Math.round (_prices.getPrices () [0] * 10000) / 10000 + " = $" + (_player.getBalances () [1] * _prices.getPrices () [0]) +
		"\nIBM: " + _player.getBalances () [2] + " x $" + (double) Math.round (_prices.getPrices () [1] * 10000) / 10000 + " = $" + (_player.getBalances () [2] * _prices.getPrices () [1]) +
		"\nTSLA: " + _player.getBalances () [3] + " x $" + (double) Math.round (_prices.getPrices () [2] * 10000) / 10000 + " = $" + (_player.getBalances () [3] * _prices.getPrices () [2]) +
		"\nAAPL: " + _player.getBalances () [4] + " x $" + (double) Math.round (_prices.getPrices () [3] * 10000) / 10000 + " = $" + (_player.getBalances () [4] * _prices.getPrices () [3]) +
		"\nUBER: " + _player.getBalances () [5] + " x $" + (double) Math.round (_prices.getPrices () [4] * 10000) / 10000 + " = $" + (_player.getBalances () [5] * _prices.getPrices () [4]) +
		"\nBTC: " + _player.getBalances () [6] + " x $" + (double) Math.round (_prices.getPrices () [5] * 10000) / 10000 + " = $" + (_player.getBalances () [6] * _prices.getPrices () [5]) +
		"\nETH: " + _player.getBalances () [7] + " x $" + (double) Math.round (_prices.getPrices () [6] * 10000) / 10000 + " = $" + (_player.getBalances () [7] * _prices.getPrices () [6]) +
		"\nDOGE: " + _player.getBalances () [8] + " x $" + (double) Math.round (_prices.getPrices () [7] * 10000) / 10000 + " = $" + (_player.getBalances () [8] * _prices.getPrices () [7]) +
		"\nAPE: " + _player.getBalances () [9] + " x $" + (double) Math.round (_prices.getPrices () [8] * 10000) / 10000 + " = $" + (_player.getBalances () [9] * _prices.getPrices () [8]) +
		"\nXMR: " + _player.getBalances () [10] + " x $" + (double) Math.round (_prices.getPrices () [9] * 10000) / 10000 + " = $" + (_player.getBalances () [10] * _prices.getPrices () [9]) +
		"\nTime played: " + (int) _player.getBalances () [11] + " days.");
    }


    public static void saveGame (PlayerAssets _player, PriceCharts _prices) throws IOException
    { // Saves all game data to a .MONEY file
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	System.out.print ("Enter the name of the file you would like to save to: ");
	String filename = br.readLine ();
	PrintWriter pr = new PrintWriter (new FileWriter (filename + ".MONEY"));
	pr.println (_player.getName ());
	pr.println (_player.getDate ().toString ());
	pr.println (_player.getBalances () [0]);

	pr.println (_player.getBalances () [1]);
	pr.println (_player.getBalances () [2]);
	pr.println (_player.getBalances () [3]);
	pr.println (_player.getBalances () [4]);
	pr.println (_player.getBalances () [5]);
	pr.println (_player.getBalances () [6]);
	pr.println (_player.getBalances () [7]);
	pr.println (_player.getBalances () [8]);
	pr.println (_player.getBalances () [9]);
	pr.println (_player.getBalances () [10]);

	pr.println (_player.getBalances () [11]);

	pr.println (_prices.getPrices () [0]);
	pr.println (_prices.getPrices () [1]);
	pr.println (_prices.getPrices () [2]);
	pr.println (_prices.getPrices () [3]);
	pr.println (_prices.getPrices () [4]);
	pr.println (_prices.getPrices () [5]);
	pr.println (_prices.getPrices () [6]);
	pr.println (_prices.getPrices () [7]);
	pr.println (_prices.getPrices () [8]);
	pr.println (_prices.getPrices () [9]);

	writePriceHistory (pr, _prices.getPriceHistory (0));
	writePriceHistory (pr, _prices.getPriceHistory (1));
	writePriceHistory (pr, _prices.getPriceHistory (2));
	writePriceHistory (pr, _prices.getPriceHistory (3));
	writePriceHistory (pr, _prices.getPriceHistory (4));
	writePriceHistory (pr, _prices.getPriceHistory (5));
	writePriceHistory (pr, _prices.getPriceHistory (6));
	writePriceHistory (pr, _prices.getPriceHistory (7));
	writePriceHistory (pr, _prices.getPriceHistory (8));
	writePriceHistory (pr, _prices.getPriceHistory (9));

	pr.close ();

	System.out.println ("Game successfully saved to file " + filename + ".MONEY");
    }


    // Menu Option Utilities


    public static boolean loadGame (PlayerAssets _player, PriceCharts _prices) throws IOException
    { // Loads a previous game from a .MONEY file
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

	System.out.println ("Enter the name of the file you would like to load. (No file extensions.)\nPress Enter to create a new game.");
	String filename = br.readLine ();
	if (filename.equals (""))
	{
	    return false;
	}
	else
	{
	    BufferedReader fr = new BufferedReader (new FileReader (filename + ".MONEY"));

	    _player.setInfo ("name", fr.readLine ());
	    Date start = new Date ();
	    fr.readLine ();
	    _player.setInfo ("date", start);
	    _player.setInfo ("money", Double.parseDouble (fr.readLine ()));
	    _player.setInfo ("wmt", Double.parseDouble (fr.readLine ()));
	    _player.setInfo ("ibm", Double.parseDouble (fr.readLine ()));
	    _player.setInfo ("tsla", Double.parseDouble (fr.readLine ()));
	    _player.setInfo ("aapl", Double.parseDouble (fr.readLine ()));
	    _player.setInfo ("uber", Double.parseDouble (fr.readLine ()));
	    _player.setInfo ("btc", Double.parseDouble (fr.readLine ()));
	    _player.setInfo ("eth", Double.parseDouble (fr.readLine ()));
	    _player.setInfo ("doge", Double.parseDouble (fr.readLine ()));
	    _player.setInfo ("ape", Double.parseDouble (fr.readLine ()));
	    _player.setInfo ("xmr", Double.parseDouble (fr.readLine ()));
	    _player.setInfo ("timeplayed", Double.parseDouble (fr.readLine ()));

	    _prices.loadPrices (Double.parseDouble (fr.readLine ()), Double.parseDouble (fr.readLine ()), Double.parseDouble (fr.readLine ()), Double.parseDouble (fr.readLine ()), Double.parseDouble (fr.readLine ()), Double.parseDouble (fr.readLine ()), Double.parseDouble (fr.readLine ()), Double.parseDouble (fr.readLine ()), Double.parseDouble (fr.readLine ()), Double.parseDouble (fr.readLine ()));
	    for (int o = 0 ; o < 5 ; o++)
	    {
		_prices.storePrice ("wmt", Double.parseDouble (fr.readLine ()));
	    }
	    for (int o = 0 ; o < 5 ; o++)
	    {
		_prices.storePrice ("ibm", Double.parseDouble (fr.readLine ()));
	    }
	    for (int o = 0 ; o < 5 ; o++)
	    {
		_prices.storePrice ("tsla", Double.parseDouble (fr.readLine ()));
	    }
	    for (int o = 0 ; o < 5 ; o++)
	    {
		_prices.storePrice ("aapl", Double.parseDouble (fr.readLine ()));
	    }
	    for (int o = 0 ; o < 5 ; o++)
	    {
		_prices.storePrice ("uber", Double.parseDouble (fr.readLine ()));
	    }
	    for (int o = 0 ; o < 5 ; o++)
	    {
		_prices.storePrice ("btc", Double.parseDouble (fr.readLine ()));
	    }
	    for (int o = 0 ; o < 5 ; o++)
	    {
		_prices.storePrice ("eth", Double.parseDouble (fr.readLine ()));
	    }
	    for (int o = 0 ; o < 5 ; o++)
	    {
		_prices.storePrice ("doge", Double.parseDouble (fr.readLine ()));
	    }
	    for (int o = 0 ; o < 5 ; o++)
	    {
		_prices.storePrice ("ape", Double.parseDouble (fr.readLine ()));
	    }
	    for (int o = 0 ; o < 5 ; o++)
	    {
		_prices.storePrice ("xmr", Double.parseDouble (fr.readLine ()));
	    }

	    System.out.println ("Game loaded successfully.");

	    return true;
	}

    }


    public static void writePriceHistory (PrintWriter pr, double[] _h)  // Writes price history data to a .MONEY file. input parameter is price history array
    {
	for (int price = 0 ; price < _h.length - 1 ; price++)
	{
	    pr.println (_h [0]);
	    pr.println (_h [1]);
	    pr.println (_h [2]);
	    pr.println (_h [3]);
	    pr.println (_h [4]);
	}
    }


    public static int StrToAssetNum (String _asset)
    {
	int _assetNumber;

	if (_asset.compareTo ("wmt") == 0)
	{
	    _assetNumber = 0;
	}
	else if (_asset.compareTo ("ibm") == 0)
	{
	    _assetNumber = 1;
	}
	else if (_asset.compareTo ("tsla") == 0)
	{
	    _assetNumber = 2;
	}
	else if (_asset.compareTo ("aapl") == 0)
	{
	    _assetNumber = 3;
	}
	else if (_asset.compareTo ("uber") == 0)
	{
	    _assetNumber = 4;
	}
	else if (_asset.compareTo ("btc") == 0)
	{
	    _assetNumber = 5;
	}
	else if (_asset.compareTo ("eth") == 0)
	{
	    _assetNumber = 6;
	}
	else if (_asset.compareTo ("doge") == 0)
	{
	    _assetNumber = 7;
	}
	else if (_asset.compareTo ("ape") == 0)
	{
	    _assetNumber = 8;
	}
	else if (_asset.compareTo ("xmr") == 0)
	{
	    _assetNumber = 9;
	}
	else
	{
	    _assetNumber = 99;
	}

	return _assetNumber;
    }
}

// ToTheMoon class
