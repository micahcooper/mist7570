<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<p> ${ results.player1.winDeck.cardsLeft > results.player2.winDeck.cardsleft ? 'player 1 wins':'player 2 wins' }</p>
	</div>
	
	<div id=gameBoard>
		<div class=card>
			Player 1:
			<img src="classic-cards/${ warGame.player1.drawDeck.topCard }.png" />
			Score: ${ warGame.player1.winDeck.cardsLeft }
			${ warGame.player1.drawDeck.topCard.value == warGame.player2.drawDeck.topCard.value ? "<img src='classic-cards/b1pl.png' /><img src='classic-cards/b1pl.png' /><img src='classic-cards/999.png' />" :  ""}
		</div>
		<div class=card>
			Player 2:
			<img src="classic-cards/${ warGame.player2.drawDeck.topCard }.png" />
			Score: ${ warGame.player2.winDeck.cardsLeft }
			${ warGame.player1.drawDeck.topCard.value == warGame.player2.drawDeck.topCard.value ? "<img src='classic-cards/b1pl.png' /><img src='classic-cards/b1pl.png' /><img src='classic-cards/999.png' />" :  ""}
		</div>
	</div>
	
	<div id=controls>
		<form name="guessForm" action="warGame" method="post" onsubmit="return validateForm()">
			<label id="guessLabel">OPTIONS: </label>
			<input type="submit" name="playTurn" value="Play a turn">
			<input type="submit" name="reset" value="RESET">
			<input type="submit" name="test" value="Stack Deck and Test">
		</form>
	</div>
	
</body>
</html>