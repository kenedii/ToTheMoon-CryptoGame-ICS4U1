import java.util.*;
import java.io.*;
import java.awt.*;

public class PlayerAssets
{
    /*
										 Ticker Guide
				     Stocks:        WMT - Walmart   IBM - IBM   TSLA - Tesla    AAPL - Apple    UBER - Uber
				    Cryptos:        BTC - Bitcoin   ETH - Ether DOGE - Dogecoin APE - Ape coin  XMR - Monero
    */
    String name;
    Date date;
    double money;
    double wmt;
    double ibm;
    double tsla;
    double aapl;
    double uber;
    double btc;
    double eth;
    double doge;
    double ape;
    double xmr;
    int timeplayed;

    public PlayerAssets (String _name, Date _date, double _money, double _wmt, double _ibm, double _tsla, double _aapl, double _uber, double _btc, double _eth, double _doge, double _ape, double _xmr, int _timeplayed)
    {
	name = _name;
	date = _date;
	money = _money;
	wmt = _wmt;
	ibm = _ibm;
	tsla = _tsla;
	aapl = _aapl;
	uber = _uber;
	btc = _btc;
	eth = _eth;
	doge = _doge;
	ape = _ape;
	xmr = _xmr;
	timeplayed = _timeplayed;
    }


    public PlayerAssets ()
    {
	name = "";
	Date date = new Date ();
	money = 10000;
	wmt = 0;
	ibm = 0;
	tsla = 0;
	aapl = 0;
	uber = 0;
	btc = 0;
	eth = 0;
	doge = 0;
	ape = 0;
	xmr = 0;
	timeplayed = 0;
    }


    public double[] getBalances ()  // One getter method that returns an array of all the doubles
    {
	double _infoarray[] = new double [12];
	_infoarray [0] = money;
	_infoarray [1] = wmt;
	_infoarray [2] = ibm;
	_infoarray [3] = tsla;
	_infoarray [4] = aapl;
	_infoarray [5] = uber;
	_infoarray [6] = btc;
	_infoarray [7] = eth;
	_infoarray [8] = doge;
	_infoarray [9] = ape;
	_infoarray [10] = xmr;
	_infoarray [11] = timeplayed;

	return _infoarray;
    }


    public Date getDate ()
    {
	return date;
    }


    public String getName ()
    {
	return name;
    }


    // Setter methods are all setInfo()
    // The first input parameter is variable name
    // The second input parameter is the new data

    public void setInfo (String _info, String _data)
    {
	if (_info.equals ("name") == true)
	{
	    name = _data;
	}
    }


    public void setInfo (String _info, Date _date)
    {
	if (_info.equals ("date") == true)
	{
	    date = _date;
	}
    }


    public void setInfo (String _info, double _data)
    {
	if (_info.equals ("money") == true)
	{
	    money = _data;
	}
	else if (_info.equals ("wmt") == true)
	{
	    wmt = _data;
	}
	else if (_info.equals ("ibm") == true)
	{
	    ibm = _data;
	}
	else if (_info.equals ("tsla") == true)
	{
	    tsla = _data;
	}
	else if (_info.equals ("aapl") == true)
	{
	    aapl = _data;
	}
	else if (_info.equals ("uber") == true)
	{
	    uber = _data;
	}
	else if (_info.equals ("btc") == true)
	{
	    btc = _data;
	}
	else if (_info.equals ("eth") == true)
	{
	    eth = _data;
	}
	else if (_info.equals ("doge") == true)
	{
	    doge = _data;
	}
	else if (_info.equals ("ape") == true)
	{
	    ape = _data;
	}
	else if (_info.equals ("xmr") == true)
	{
	    xmr = _data;
	}
	else if (_info.equals ("timeplayed") == true)
	{
	    timeplayed = (int) (_data);
	}
    }
}
