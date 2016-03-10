<html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="stylesheet.css" />
	
	<title>This Is War, Peacock</title>		
</head>
<body>

	<div id=header>
		<h1>This is War</h1>
	</div>
	
	<div id=gameBoard>
		<div class=card>
			Player 1:
			<img src="classic-cards/${ warGame.player1.drawDeck.topCard }.png" />
			Score: ${ warGame.player1.winDeck.cardsLeft }
		</div>
		<div class=card>
			Player 2:
			<img src="classic-cards/${ warGame.player2.drawDeck.topCard }.png" />
			Score: ${ warGame.player2.winDeck.cardsLeft }
		</div>
	</div>
	
	<div id=controls>
		<form name="guessForm" action="warGame" method="post" onsubmit="return validateForm()">
			<label id="guessLabel">Play turn:</label>
			<input type="submit" name="playTurn" value="Play a turn">
		</form>
	</div>
	
</body>
</html>