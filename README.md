# ToTheMoon-CryptoGame
A java text based crypto simulation game using statistics made for my ICS4U1 culminating assignment 2022. Run the 'ToTheMoon.java' file
Dependencies: hsa.Console (Ready To Program Java IDE)

**ToTheMoon class**

Contains the main method

Creates the objects needed for the game

Asks the user what they would like to do during their turn

**AssetPrices class**

Generates the prices for each asset in the beginning of the game

Contains methods to update the price of each asset after each turn

Returns the value of each asset to the main method

Creates a chart to model the in-game price of an asset


**PlayerAssets class**

Contains info about how much money the player has, and how much of each asset they have

Has methods to show the user what assets they own, how much money they have, and what their assets are worth.

To determine what the price of the asset will be the next day, I used historical data for each asset to see how frequently the asset goes up or down by a certain amount. 
Example: 
Bitcoin went up by 0.3% to 3.4% from the previous day, 597/1825 times in the past 5 years.

597/1825 = 32.7% Price in game will go up by 0.3 to 3.4%, 32.7% of the time.

Flaws With This Way of Generating Prices:

	-“Past performance is not indicative of future results”
	-Randomness can cause the asset to become worthless or hyperinflated
	-Predictable/Deterministic (follows normal distribution in the long term)
