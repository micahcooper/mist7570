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
		<p> ${ warGame.dealer.showCard && warGame.player1.memoryDeck.lastCard.value > warGame.player2.memoryDeck.lastCard.value ? 'player 1 wins': "" }</p>
		<p> ${ warGame.dealer.showCard && warGame.player1.memoryDeck.lastCard.value < warGame.player2.memoryDeck.lastCard.value ? 'player 2 wins': "" }</p>
		<p> ${ warGame.dealer.showCard && warGame.player1.memoryDeck.lastCard.value == warGame.player2.memoryDeck.lastCard.value ? 'It has begun! Choose your war card wisely.':'' }
	</div>
	
	<div id=gameBoard>
		<div class=card>
			Player 1: <img src='classic-cards/${ warGame.dealer.showCard ?  warGame.player1.memoryDeck.lastCard : "999"  }.png' />
			Score: ${ warGame.player1.winDeck.cardsLeft }
			${ warGame.dealer.timeOfWar ? "<img src='classic-cards/b1pl.png' /><img src='classic-cards/b1pl.png' /><img src='classic-cards/999.png' />" :  ""}
		</div>
		<div class=card>
			Player 2: <img src='classic-cards/${ warGame.dealer.showCard ?  warGame.player2.memoryDeck.lastCard : "999" }.png' />
			Score: ${ warGame.player2.winDeck.cardsLeft }
			${ warGame.dealer.timeOfWar ? "<img src='classic-cards/b1pl.png' /><img src='classic-cards/b1pl.png' /><img src='classic-cards/b1pl.png' />" :  ""}<img src='classic-cards/${ warGame.dealer.timeOfWar ?  warGame.player2.drawDeck.topCard : "blank" }.png' />
		</div>
		<p style='max-width:400px'>${ warGame.dealer.timeOfWar ? "Total cards to be captured: " : "" }${ warGame.dealer.spoilsOfWar }</p>
	</div>
	
	<div id=controls>
		<form name="guessForm" action="warGame" method="post" onsubmit="return validateForm()">
			${ warGame.dealer.showCard  ? "" : "<input type='submit' name='draw' value='Draw and Start Game'>" }
			${ warGame.dealer.showCard  ? "<input type='submit' name='draw' value='Draw'>" : "" }
			${ warGame.dealer.timeOfWar  ? "<input type='submit' name='goToWar' value='Show War Card'>" : "" }
			<input type="submit" name="test" value="Stack Deck and Test">
			<input type="submit" name="reset" value="RESET">
		</form>
	</div>
	
</body>
</html>