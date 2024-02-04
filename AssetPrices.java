import java.util.*;
import java.io.*;
import java.awt.*;

public class AssetPrices extends ToTheMoon
{
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
    double _wmt;
    double _ibm;
    double _tsla;
    double _aapl;
    double _uber;
    double _btc;
    double _eth;
    double _doge;
    double _ape;
    double _xmr;

    // Constructor generates new asset prices from a range of +- 10% of the asset's real life price from when i started coding this
    public AssetPrices ()
    {
	wmt = (Math.random () * 131) + 107;
	ibm = (Math.random () * 143) + 117;
	tsla = (Math.random () * 789) + 645;
	aapl = (Math.random () * 151) + 124;
	uber = (Math.random () * 26) + 21;
	btc = (Math.random () * 33190) + 27155;
	eth = (Math.random () * 2113) + 1728;
	doge = ((Math.random () * 94) + 77) / 1000;
	ape = ((Math.random () * 699) + 572) / 100;
	xmr = (Math.random () * 181) + 148;
    }


    public void updatePrices (int _days)  // Moves the price of each asset based on their own algorithms
    {
	updateWMT (_days);
	updateAAPL (_days);
	updateTSLA (_days);
	updateIBM (_days);
	updateUBER (_days);
	updateBTC (_days);
	updateETH (_days);
	updateDOGE (_days);
	updateXMR (_days);
	updateAPE (_days);

    }


    //                                                        Loads prices if game was loaded from file
    public void loadPrices (double wmt, double ibm, double tsla, double aapl, double uber, double btc, double eth, double doge, double ape, double xmr)
    {
	this.wmt = wmt;
	this.ibm = ibm;
	this.tsla = tsla;
	this.aapl = aapl;
	this.uber = uber;
	this.btc = btc;
	this.eth = eth;
	this.doge = doge;
	this.ape = ape;
	this.xmr = xmr;
    }


    public void updateBTC (int _days)
    {
	for (int _i = 0 ; _i < _days ; _i++) // Loop will iterate for number of days that are skipped forward. (Default is 1 day)
	{
	    _btc = (Math.random () * 1826) + 1; //Picks a random number out of 1826 so I could have it model my real price distribution histograms that had 1826 days of data
	    if (_btc <= 1)
	    {
		_btc = (Math.random () * 3717) + 2677;
		_btc = (_btc / 10000) * (-1);
		btc = btc + (btc * _btc);
	    }
	    else if ((_btc > 1)
		    && (_btc <= 3))
	    {
		_btc = (Math.random () * 2677) + 1636;
		_btc = (_btc / 10000) * (-1);
		btc = btc + (btc * _btc);
	    } // Example:
	    else if ((_btc > 3)           // 104 times in the past 1826 days . . .
		    && (_btc <= 107))                 // Bitcoin's real price fall was from -16.36% to -5.98%
	    {
		_btc = (Math.random () * 1636) + 598;    // Generates the % that the price will rise/fall by. 104/1826 chance to fall from -16.36% to -5.98%
		_btc = (_btc / 10000) * (-1);
		btc = btc + (btc * _btc);
	    }
	    else if ((_btc > 107)
		    && (_btc <= 1625))
	    {
		_btc = (Math.random () * 594) + 1;
		_btc = (_btc / 10000);
		int _n = (int) ((Math.random () * 5) + 1);
		if ((_n <= 3))
		{
		    _btc = _btc * -1;
		}
		btc = btc + (btc * _btc);
	    }
	    else if ((_btc > 1625)
		    && (_btc <= 1817))
	    {
		_btc = (Math.random () * 1484) + 444;
		_btc = (_btc / 10000);
		btc = btc + (btc * _btc);
	    }
	    else if ((_btc > 1817)
		    && (_btc <= 1826))
	    {
		_btc = (Math.random () * 2525) + 1484;
		_btc = (_btc / 10000);
		btc = btc + (btc * _btc);
	    }

	    storePrice ("btc", btc);
	}

    }


    public void updateUBER (int _days)
    {
	for (int _i = 0 ; _i < _days ; _i++)
	{
	    _uber = (Math.random () * 767) + 1;
	    if (_uber <= 1)
	    {
		_uber = (Math.random () * 2163) + 1552;
		_uber = (_uber / 10000) * (-1);
		uber = uber + (uber * _uber);
	    }
	    else if ((_uber > 1)
		    && (_uber <= 9))
	    {
		_uber = (Math.random () * 1552) + 942;
		_uber = (_uber / 10000) * (-1);
		uber = uber + (uber * _uber);
	    }
	    else if ((_uber > 9)
		    && (_uber <= 102))
	    {
		_uber = (Math.random () * 942) + 331;
		_uber = (_uber / 10000) * (-1);
		uber = uber + (uber * _uber);
	    }
	    else if ((_uber > 102)
		    && (_uber <= 636))
	    {
		_uber = (Math.random () * 331) + (1);
		_uber = (_uber / 10000);
		int _n = (int) ((Math.random () * 2) + 1);
		if ((_n == 1))
		{
		    _uber = _uber * -1;
		}

		uber = uber + (uber * _uber);
	    }
	    else if ((_uber > 636)
		    && (_uber <= 759))
	    {
		_uber = (Math.random () * 890) + 279;
		_uber = (_uber / 10000);
		uber = uber + (uber * _uber);
	    }
	    else if ((_uber > 759)
		    && (_uber <= 765))
	    {
		_uber = (Math.random () * 1500) + 890;
		_uber = (_uber / 10000);
		uber = uber + (uber * _uber);
	    }

	    else if ((_uber > 765)
		    && (_uber <= 767))
	    {
		_uber = (Math.random () * 2000) + 1500;
		_uber = (_uber / 10000);
		uber = uber + (uber * _uber);
	    }

	    storePrice ("uber", uber);
	}

    }


    public void updateWMT (int _days)
    {
	for (int _i = 0 ; _i < _days ; _i++)
	{
	    _wmt = (Math.random () * 1257) + 1;
	    if (_wmt <= 5)
	    {
		_wmt = (Math.random () * 1048) + 660;
		_wmt = (_wmt / 10000) * (-1);
		wmt = wmt + (wmt * _wmt);
	    }
	    else if ((_wmt > 6)
		    && (_wmt <= 21))
	    {
		_wmt = (Math.random () * 660) + 271;
		_wmt = (_wmt / 10000) * (-1);
		wmt = wmt + (wmt * _wmt);
	    }
	    else if ((_wmt > 21)
		    && (_wmt <= 1105))
	    {
		_wmt = (Math.random () * 271) + 1;
		_wmt = (_wmt / 10000);
		int _n = (int) ((Math.random () * 13) + 1);
		if ((_n <= 10))
		{
		    _wmt = _wmt * -1;
		}
		wmt = wmt + (wmt * _wmt);
	    }
	    else if ((_wmt > 1105)
		    && (_wmt <= 1251))
	    {
		_wmt = (Math.random () * 506) + 118;
		_wmt = (_wmt / 10000);
		wmt = wmt + (wmt * _wmt);
	    }
	    else if ((_wmt > 1251)
		    && (_wmt <= 1255))
	    {
		_wmt = (Math.random () * 895) + 506;
		_wmt = (_wmt / 10000);
		wmt = wmt + (wmt * _wmt);
	    }
	    else if ((_wmt > 1255)
		    && (_wmt <= 1258))
	    {
		_wmt = (Math.random () * 1285) + 895;
		_wmt = (_wmt / 10000);
		wmt = wmt + (wmt * _wmt);
	    }

	    storePrice ("wmt", wmt);
	}

    }


    public void updateAAPL (int _days)
    {
	for (int _i = 0 ; _i < _days ; _i++)
	{
	    _aapl = (Math.random () * 1325) + 1;
	    if (_aapl <= 3)
	    {
		_aapl = (Math.random () * 1286) + 872;
		_aapl = (_aapl / 10000) * (-1);
		aapl = aapl + (aapl * _aapl);
	    }
	    else if ((_aapl > 3)
		    && (_aapl <= 23))
	    {
		_aapl = (Math.random () * 872) + 458;
		_aapl = (_aapl / 10000) * (-1);
		aapl = aapl + (aapl * _aapl);
	    }
	    else if ((_aapl > 23)
		    && (_aapl <= 201))
	    {
		_aapl = (Math.random () * 458) + 44;
		_aapl = (_aapl / 10000) * (-1);
		aapl = aapl + (aapl * _aapl);
	    }
	    else if ((_aapl > 201)
		    && (_aapl <= 1221))
	    {
		_aapl = (Math.random () * 370) + 1;
		_aapl = (_aapl / 10000);
		int _n = (int) ((Math.random () * 16) + 1);
		if ((_n <= 13))
		{
		    _aapl = _aapl * -1;
		}
		aapl = aapl + (aapl * _aapl);
	    }
	    else if ((_aapl > 1221)
		    && (_aapl <= 1300))
	    {
		_aapl = (Math.random () * 784) + 370;
		_aapl = (_aapl / 10000);
		aapl = aapl + (aapl * _aapl);
	    }
	    else if ((_aapl > 1300)
		    && (_aapl <= 1325))
	    {
		_aapl = (Math.random () * 1198) + 784;
		_aapl = (_aapl / 10000);
		aapl = aapl + (aapl * _aapl);
	    }

	    storePrice ("aapl", aapl);

	}

    }


    public void updateTSLA (int _days)
    {
	for (int _i = 0 ; _i < _days ; _i++)
	{
	    _tsla = (Math.random () * 1258) + 1;
	    if (_tsla <= 4)
	    {
		_tsla = (Math.random () * 2106) + 1424;
		_tsla = (_tsla / 10000) * (-1);
		tsla = tsla + (tsla * _tsla);
	    }
	    else if ((_tsla > 4)
		    && (_tsla <= 34))
	    {
		_tsla = (Math.random () * 1424) + 741;
		_tsla = (_tsla / 10000) * (-1);
		tsla = tsla + (tsla * _tsla);
	    }
	    else if ((_tsla > 34)
		    && (_tsla <= 250))
	    {
		_tsla = (Math.random () * 741) + 58;
		_tsla = (_tsla / 10000) * (-1);
		tsla = tsla + (tsla * _tsla);
	    }
	    else if ((_tsla > 250)
		    && (_tsla <= 1189))
	    {
		_tsla = (Math.random () * 624) + 1;
		_tsla = (_tsla / 10000);
		int _n = (int) ((Math.random () * 5) + 1);
		if ((_n <= 2))
		{
		    _tsla = _tsla * -1;
		}
		tsla = tsla + (tsla * _tsla);
	    }
	    else if ((_tsla > 1189)
		    && (_tsla <= 1246))
	    {
		_tsla = (Math.random () * 1307) + 624;
		_tsla = (_tsla / 10000);
		tsla = tsla + (tsla * _tsla);
	    }
	    else if ((_tsla > 1246)
		    && (_tsla <= 1258))
	    {
		_tsla = (Math.random () * 1989) + 1307;
		_tsla = (_tsla / 10000);
		tsla = tsla + (tsla * _tsla);
	    }

	    storePrice ("tsla", tsla);

	}

    }


    public void updateIBM (int _days)
    {
	for (int _i = 0 ; _i < _days ; _i++)
	{
	    _ibm = (Math.random () * 1257) + 1;
	    if (_ibm <= 4)
	    {
		_ibm = (Math.random () * 1285) + 883;
		_ibm = (_ibm / 10000) * (-1);
		ibm = ibm + (ibm * _ibm);
	    }
	    else if ((_ibm > 4)
		    && (_ibm <= 13))
	    {
		_ibm = (Math.random () * 883) + 480;
		_ibm = (_ibm / 10000) * (-1);
		ibm = ibm + (ibm * _ibm);
	    }
	    else if ((_ibm > 13)
		    && (_ibm <= 100))
	    {
		_ibm = (Math.random () * 480) + 77;
		_ibm = (_ibm / 10000) * (-1);
		ibm = ibm + (ibm * _ibm);
	    }
	    else if ((_ibm > 100)
		    && (_ibm <= 1123))
	    {
		_ibm = (Math.random () * 325) + (1);
		_ibm = (_ibm / 10000);
		int _n = (int) ((Math.random () * 5) + 1);
		if ((_n <= 2))
		{
		    _ibm = _ibm * -1;
		}
		ibm = ibm + (ibm * _ibm);
	    }
	    else if ((_ibm > 1123)
		    && (_ibm <= 1153))
	    {
		_ibm = (Math.random () * 728) + 325;
		_ibm = (_ibm / 10000);
		ibm = ibm + (ibm * _ibm);
	    }
	    else if ((_ibm > 1153)
		    && (_ibm <= 1157))
	    {
		_ibm = (Math.random () * 1130) + 728;
		_ibm = (_ibm / 10000);
		ibm = ibm + (ibm * _ibm);
	    }

	    storePrice ("ibm", ibm);

	}

    }


    public void updateETH (int _days)
    {
	for (int _i = 0 ; _i < _days ; _i++)
	{
	    _eth = (Math.random () * 1659) + 1;
	    if (_eth <= 13)
	    {
		_eth = (Math.random () * 2500) + 1500;
		_eth = (_eth / 10000) * (-1);
		eth = eth + (eth * _eth);
	    }
	    else if ((_eth > 13)
		    && (_eth <= 180))
	    {
		_eth = (Math.random () * 1500) + 500;
		_eth = (_eth / 10000) * (-1);
		eth = eth + (eth * _eth);
	    }
	    else if ((_eth > 180)
		    && (_eth <= 1431))
	    {
		_eth = (Math.random () * 500) + 1;
		_eth = (_eth / 10000);
		int _n = (int) ((Math.random () * 5) + 1);
		if ((_n <= 2))
		{
		    _eth = _eth * -1;
		}
		eth = eth + (eth * _eth);
	    }
	    else if ((_eth > 1431)
		    && (_eth <= 1646))
	    {
		_eth = (Math.random () * 1500) + 500;
		_eth = (_eth / 10000);
		eth = eth + (eth * _eth);
	    }
	    else if ((_eth > 1646)
		    && (_eth <= 1649))
	    {
		_eth = (Math.random () * 2700) + 1500;
		_eth = (_eth / 10000);
		eth = eth + (eth * _eth);
	    }

	    storePrice ("eth", eth);

	}

    }


    public void updateDOGE (int _days)
    {
	for (int _i = 0 ; _i < _days ; _i++)
	{
	    _doge = (Math.random () * 1325) + 1;
	    if (_doge <= 10)
	    {
		_doge = (Math.random () * 3000) + 2621;
		_doge = (_doge / 10000) * (-1);
		doge = doge + (doge * _doge);
	    }
	    else if ((_doge > 10)
		    && (_doge <= 53))
	    {
		_doge = (Math.random () * 2621) + 1215;
		_doge = (_doge / 10000) * (-1);
		doge = doge + (doge * _doge);
	    }
	    else if ((_doge > 53)
		    && (_doge <= 1241))
	    {
		_doge = (Math.random () * 1215) + 190;
		_doge = (_doge / 10000);
		int _n = (int) ((Math.random () * 3) + 1);
		if ((_n <= 2))
		{
		    _doge = _doge * -1;
		}
		doge = doge + (doge * _doge);
	    }
	    else if ((_doge > 1241)
		    && (_doge <= 1295))
	    {
		_doge = (Math.random () * 550) + 190;
		_doge = (_doge / 10000);
		doge = doge + (doge * _doge);
	    }
	    else if ((_doge > 1295)
		    && (_doge <= 1320))
	    {
		_doge = (Math.random () * 3000) + 550;
		_doge = (_doge / 10000);
		doge = doge + (doge * _doge);
	    }
	    else if ((_doge > 1320)
		    && (_doge <= 1325))
	    {
		_doge = (Math.random () * 4500) + 3000;
		_doge = (_doge / 10000);
		doge = doge + (doge * _doge);
	    }

	    storePrice ("doge", doge);

	}
    }


    public void updateXMR (int _days)
    {
	for (int _i = 0 ; _i < _days ; _i++)
	{
	    _xmr = (Math.random () * 1659) + 1;
	    if (_xmr <= 2)
	    {
		_xmr = (Math.random () * 2700) + 2500;
		_xmr = (_xmr / 10000) * (-1);
		xmr = xmr + (xmr * _xmr);
	    }
	    else if ((_xmr > 2)
		    && (_xmr <= 31))
	    {
		_xmr = (Math.random () * 2500) + 1250;
		_xmr = (_xmr / 10000) * (-1);
		xmr = xmr + (xmr * _xmr);
	    }
	    else if ((_xmr > 31)
		    && (_xmr <= 799))
	    {
		_xmr = (Math.random () * 1250) + (0);
		_xmr = (_xmr / 10000) * (-1);
		xmr = xmr + (xmr * _xmr);
	    }
	    else if ((_xmr > 799)
		    && (_xmr <= 1626))
	    {
		_xmr = (Math.random () * 1250) + 0;
		_xmr = (_xmr / 10000);
		xmr = xmr + (xmr * _xmr);
	    }
	    else if ((_xmr > 1626)
		    && (_xmr <= 1655))
	    {
		_xmr = (Math.random () * 2500) + 1250;
		_xmr = (_xmr / 10000);
		xmr = xmr + (xmr * _xmr);
	    }
	    else if ((_xmr > 1655)
		    && (_xmr <= 1659))
	    {
		_xmr = (Math.random () * 2700) + 2500;
		_xmr = (_xmr / 10000);
		xmr = xmr + (xmr * _xmr);
	    }

	    storePrice ("xmr", xmr);

	}

    }


    public void updateAPE (int _days)
    {
	for (int _i = 0 ; _i < _days ; _i++)
	{
	    _ape = (Math.random () * 605) + 1;
	    if ((_ape > 0)
		    && (_ape <= 3))
	    {
		_ape = (Math.random () * 6500) + 4200;
		_ape = (_ape / 10000) * (-1);
		ape = ape + (ape * _ape);
	    }
	    else if ((_ape > 3)
		    && (_ape <= 48))
	    {
		_ape = (Math.random () * 4200) + 1400;
		_ape = (_ape / 10000) * (-1);
		ape = ape + (ape * _ape);
	    }
	    else if ((_ape > 48)
		    && (_ape <= 553))
	    {
		_ape = (Math.random () * 1400) + 1;
		_ape = (_ape / 10000);
		int _n = (int) ((Math.random () * 2) + 1);
		if (_n == 2)
		{
		    _ape = (_ape) * (-1);
		}
		ape = ape + (ape * _ape);
	    }
	    else if ((_ape > 553)
		    && (_ape <= 605))
	    {
		_ape = (Math.random () * 7000) + 1400;
		_ape = (_ape / 10000);
		ape = ape + (ape * _ape);
	    }

	    storePrice ("ape", ape);

	}

    }


    public double[] getPrices ()  // Getter method that returns all prices in double array
    {
	double[] _assetarray = new double [10];
	_assetarray [0] = wmt;
	_assetarray [1] = ibm;
	_assetarray [2] = tsla;
	_assetarray [3] = aapl;
	_assetarray [4] = uber;
	_assetarray [5] = btc;
	_assetarray [6] = eth;
	_assetarray [7] = doge;
	_assetarray [8] = ape;
	_assetarray [9] = xmr;
	return _assetarray;
    }


    public double[] getPriceHistory (int _assetNumber)
    { // Getter method that returns array of price history.
	if (_assetNumber == 0)
	{
	    return wmtp;
	}
	else if (_assetNumber == 1)
	{
	    return ibmp;
	}
	else if (_assetNumber == 2)
	{
	    return tslap;
	}
	else if (_assetNumber == 3)
	{
	    return aaplp;
	}
	else if (_assetNumber == 4)
	{
	    return uberp;
	}
	else if (_assetNumber == 5)
	{
	    return btcp;
	}
	else if (_assetNumber == 6)
	{
	    return ethp;
	}
	else if (_assetNumber == 7)
	{
	    return dogep;
	}
	else if (_assetNumber == 8)
	{
	    return apep;
	}
	else if (_assetNumber == 9)
	{
	    return xmrp;
	}
	else
	{
	    return null;
	}
    }


    public void printPrices ()  // Prints the price of every asset as well as the change from the previous day.
    {
	c.clear ();
	c.println ("   Today's Market Prices");
	c.println ("WMT: $" + ((double) Math.round (wmt * 10000)) / 10000 + checkNegative (_wmt) +
		"\nIBM: $" + ((double) Math.round (ibm * 10000)) / 10000 + checkNegative (_ibm) +
		"\nTSLA: $" + ((double) Math.round (tsla * 10000)) / 10000 + checkNegative (_tsla) +
		"\nAAPL: $" + ((double) Math.round (aapl * 10000)) / 10000 + checkNegative (_aapl) +
		"\nUBER: $" + ((double) Math.round (uber * 10000)) / 10000 + checkNegative (_uber) +
		"\nBTC: $" + ((double) Math.round (btc * 10000)) / 10000 + checkNegative (_btc) +
		"\nETH: $" + ((double) Math.round (eth * 10000)) / 10000 + checkNegative (_eth) +
		"\nDOGE: $" + ((double) Math.round (doge * 10000)) / 10000 + checkNegative (_doge) +
		"\nAPE: $" + ((double) Math.round (ape * 10000)) / 10000 + checkNegative (_ape) +
		"\nXMR: $" + ((double) Math.round (xmr * 10000)) / 10000 + checkNegative (_xmr));
    }


    public String checkNegative (double _num)  // Checks if the % change in price is positive, negative, or 0 for printPrices method
    {
	if (_num > 0)
	{
	    String _l = "   up (" + (double) Math.round ((_num * 100) * 100) / 100 + ")%";
	    return _l;
	}

	else if (_num < 0)
	{
	    String _l = "   down (" + (double) Math.round ((_num * 100) * 100) / 100 + ")%";
	    return _l;
	}

	else
	{
	    String _l = "   = (" + (double) Math.round ((_num * 100) * 100) / 100 + ")%";
	    return _l;
	}
    }


    // Double arrays for price history of every asset. holds prices from the past 5 days.
    double[] wmtp = new double [5];
    double[] aaplp = new double [5];
    double[] uberp = new double [5];
    double[] ibmp = new double [5];
    double[] tslap = new double [5];
    double[] btcp = new double [5];
    double[] apep = new double [5];
    double[] dogep = new double [5];
    double[] xmrp = new double [5];
    double[] ethp = new double [5];

    public void storePrice (String _a, double _p)  // Adds the price to the array after every day.
    {
	if (_a.equals ("wmt") == true)
	{
	    for (int c = 4 ; c > 0 ; c--)
	    {
		wmtp [c] = wmtp [c - 1];
	    }
	    wmtp [0] = _p;
	}

	else if (_a.equals ("tsla") == true)
	{
	    for (int c = 4 ; c > 0 ; c--)
	    {
		tslap [c] = tslap [c - 1];
	    }
	    tslap [0] = _p;
	}

	else if (_a.equals ("aapl") == true)
	{
	    for (int c = 4 ; c > 0 ; c--)
	    {
		aaplp [c] = aaplp [c - 1];
	    }
	    aaplp [0] = _p;
	}

	else if (_a.equals ("uber") == true)
	{
	    for (int c = 4 ; c > 0 ; c--)
	    {
		uberp [c] = uberp [c - 1];
	    }
	    uberp [0] = _p;
	}

	else if (_a.equals ("ibm") == true)
	{
	    for (int c = 4 ; c > 0 ; c--)
	    {
		ibmp [c] = ibmp [c - 1];
	    }
	    ibmp [0] = _p;
	}

	else if (_a.equals ("btc") == true)
	{
	    for (int c = 4 ; c > 0 ; c--)
	    {
		btcp [c] = btcp [c - 1];
	    }
	    btcp [0] = _p;
	}

	else if (_a.equals ("xmr") == true)
	{
	    for (int c = 4 ; c > 0 ; c--)
	    {
		xmrp [c] = xmrp [c - 1];
	    }
	    xmrp [0] = _p;
	}

	else if (_a.equals ("doge") == true)
	{
	    for (int c = 4 ; c > 0 ; c--)
	    {
		dogep [c] = dogep [c - 1];
	    }
	    dogep [0] = _p;
	}

	else if (_a.equals ("eth") == true)
	{
	    for (int c = 4 ; c > 0 ; c--)
	    {
		ethp [c] = ethp [c - 1];
	    }
	    ethp [0] = _p;
	}

	else if (_a.equals ("ape") == true)
	{
	    for (int c = 4 ; c > 0 ; c--)
	    {
		apep [c] = apep [c - 1];
	    }
	    apep [0] = _p;
	}
    }
} // end of assetprices class


