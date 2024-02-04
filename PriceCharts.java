// The "PriceCharts" class.
import java.awt.*;
import hsa.Console;

public class PriceCharts extends AssetPrices
{
    static int interval = 118; // The interval that each point on the chart is spaced away at.



    public void generateChart (int _assetNumber)
    {
	String assetName = ANtoString (_assetNumber);
	double[] p = getPriceHistory (_assetNumber);
	c.clear ();

	// Gets the lowest, highest, middle, and range of the price history.
	double[] lh = lowInArray (p);

	double top = lh [1] + (lh [1] * 0.1);
	double bottom = lh [0] - (lh [0] * 0.1);

	double middle = ((top + bottom) / 2);
	double range = ((top) - bottom);


	// Creates x and y axis
	t.setPosition (10, 10);
	t.setAngle (270);
	t.move (480);
	t.setAngle (0);
	t.move (620);

	// Goes back to left side of chart
	t.hideTrace ();


	// Draws point of first price
	double point1 = ((p [4] - bottom) / range);
	int p1 = (int) (480 - (point1 * 480));
	t.setPosition (interval * 1, p1);
	t.showTrace ();

	// Draws point of second price
	double point2 = ((p [3] - bottom) / range);
	int p2 = (int) (480 - (point2 * 480));
	t.setAngle (calcAngle (p1, p2, 2));
	t.move (calcDistance (p1, p2, 2));

	// Draws point of third price
	double point3 = ((p [2] - bottom) / range);
	int p3 = (int) (490 - (point3 * 490));
	t.setAngle (calcAngle (p2, p3, 3));
	t.move (calcDistance (p2, p3, 3));


	// Draws point of fourth price
	double point4 = ((p [1] - bottom) / range);
	int p4 = (int) (480 - (point4 * 480));
	t.setAngle (calcAngle (p3, p4, 4));
	t.move (calcDistance (p3, p4, 4));


	// Draws point of fifth price
	double point5 = ((p [0] - bottom) / range);
	int p5 = (int) (480 - (point5 * 480));
	t.setAngle (calcAngle (p4, p5, 5));
	t.move (calcDistance (p4, p5, 5));

	// Y-axis labels (Prices on right side of graph)
	Font courierBold10 = new Font ("Courier", Font.BOLD, 15);
	c.setFont (courierBold10);

	c.setColor (Color.green);
	c.drawString ("$" + Double.toString (top), 610, 20);
	c.drawString ("$" + Double.toString (((top + ((top + middle) / 2)) / 2)), 610, 73);
	c.drawString ("$" + Double.toString (((top + middle) / 2)), 610, 127);
	c.drawString ("$" + Double.toString (((middle + ((top + middle) / 2)) / 2)), 610, 181);

	c.setColor (Color.black);
	c.drawString ("$" + Double.toString (middle), 610, 235);
	c.drawString (assetName + " Price Chart (Past 5 days)", (672 / 3) - 50, 10);

	c.setColor (Color.red);
	c.drawString ("$" + Double.toString (((middle + ((middle + bottom) / 2)) / 2)), 610, 293);
	c.drawString ("$" + Double.toString (((middle + bottom) / 2)), 610, 352);
	c.drawString ("$" + Double.toString (((bottom + ((middle + bottom) / 2)) / 2)), 610, 411);
	c.drawString ("$" + Double.toString (bottom), 610, 470);

	// X Axis labels (# of days ago)
	// Green: Day was up from previous day     Red: Day was down from previous day
	c.setColor (Color.black);
	c.drawString ("Days ago", (3 * interval) - 30, 550);

	// xAxisColour();
	c.drawString ("4", interval, 510);
	// xAxisColour();
	c.drawString ("3", 2 * interval, 510);
	//xAxisColour();
	c.drawString ("2", 3 * interval, 510);
	// xAxisColour();
	c.drawString ("1", 4 * interval, 510);
	// xAxisColour();
	c.drawString ("0", 5 * interval, 510);
	// xAxisColour();

    }


    // Returns the lowest and highest number in a given array [low][high]
    public double[] lowInArray (double[] p)
    {
	int length = 5;
	double[] lowhigh = {p [0], p [0] };
	for (int r = 0 ; r < p.length - 1 ; r++)
	{
	    if (p [r] < lowhigh [0])
	    {
		lowhigh [0] = p [r];
	    }

	    if (p [r] > lowhigh [1])
	    {
		lowhigh [1] = p [r];
	    }
	}
	return lowhigh;

    }


    public static String ANtoString (int _AssetNumber)
    {
	String name = "";
	if (_AssetNumber == 0)
	{
	    name = "Walmart";
	}
	else if (_AssetNumber == 1)
	{
	    name = "IBM";
	}
	else if (_AssetNumber == 2)
	{
	    name = "Tesla";
	}
	else if (_AssetNumber == 3)
	{
	    name = "Apple";
	}
	else if (_AssetNumber == 4)
	{
	    name = "Uber";
	}
	else if (_AssetNumber == 5)
	{
	    name = "Bitcoin";
	}
	else if (_AssetNumber == 6)
	{
	    name = "Ethereum";
	}
	else if (_AssetNumber == 7)
	{
	    name = "Dogecoin";
	}
	else if (_AssetNumber == 8)
	{
	    name = "Apecoin";
	}
	else if (_AssetNumber == 9)
	{
	    name = "Monero";
	}

	return name;
    }


    public static void xAxisColour (double _c)  // Changes the colour of the X-Axis Label based on price change from previous day.
    {
	if (_c < 0)
	{
	    c.setColor (Color.red);
	}
	else if (_c == 0)
	{
	    c.setColor (Color.black);
	}
	else if (_c > 0)
	{
	    c.setColor (Color.green);
	}
    }


    // Calculates the angle from one point to another
    public static int calcAngle (int p1, int p2, int _n)
    {

	double xd = (interval * _n) - (interval * (_n - 1));
	double yd = p2 - p1;
	// Finds the angle in radians with Math.atan2 and then converts it to degrees with Math.toDegrees
	int angle = (int) (Math.toDegrees (Math.atan2 (yd, xd)));
	angle = 360 - angle;
	return angle;
    }


    // Calculates the distance from one point to another
    public static int calcDistance (int y1, int y2, int _n)
    {
	double distance = Math.sqrt (Math.pow ((interval * _n - (interval * (_n - 1))), 2) + Math.pow ((y2 - y1), 2));
	return (int) distance;
    }
} // PriceCharts class
