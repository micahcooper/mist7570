<%@page import="model.WarLogic" %>
<% WarLogic warGame = (WarLogic) session.getAttribute("warGame"); %>
<html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="stylesheet.css" />
	
	<title>This Is War, Peacock</title>		
</head>
<body>
<div id=container>
	<div id=header>
		<h1>This is War</h1>
		<p>${ warGame.message }</p>
	</div>
	
	<div id=gameBoard>
		<div id=cards>
			<div class=cards>
				<div class=player style="float:left;">${warGame.player1.name}, Score: ${ warGame.player1.score }</div>
				<div class=card><img src='classic-cards/${ warGame.dealer.showCard ?  warGame.player1.memoryDeck.lastCard : "999"  }.png' /></div>
				<%
				if(warGame != null)
					for(int i=1; i < warGame.getPlayer1().getWarDeck().getCardsLeft(); i++)	{
						request.setAttribute("card",warGame.getPlayer1().getWarDeck().getCard(i).toString() );%>
						<div class=card><img src= "classic-cards/${ card }.png"/></div>
					<%}%>
				<div class=card><img class=warCard src='classic-cards/${ showWarCard ?  warGame.player1.warCard : "blank" }.png' /></div>
			</div>
			<div class=break></div>
			<div class=cards>
				<div class=player style="float:left;">${warGame.player2.name}, Score: ${ warGame.player2.score }</div>
				<div class=card><img src='classic-cards/${ warGame.dealer.showCard ?  warGame.player2.memoryDeck.lastCard : "999"  }.png' /></div>
				<%
				if(warGame != null)
					for(int i=1; i < warGame.getPlayer2().getWarDeck().getCardsLeft(); i++)	{
						request.setAttribute("card",warGame.getPlayer2().getWarDeck().getCard(i).toString() );%>
						<div class=card><img src= "classic-cards/${ card }.png"/></div>
					<%}%>
				<div class=card><img class=warCard src='classic-cards/${ showWarCard ?  warGame.player2.warCard : "blank" }.png' /></div>
			</div>
		</div>
	</div>
	<div class=break></div>
	<div id=controls>
		<form name="guessForm" action="warGame" method="post" onsubmit="return validateForm()">
			${ !warGame.dealer.showCard && !name1Set ? "<label>First Player Name</label>" : "" }
			${ !warGame.dealer.showCard && !name1Set ? "<input type='text' name='player1Name'>" : "" }
			${ !warGame.dealer.showCard && !name2Set ? "<label>Second Player Name</label>" : "" }
			${ !warGame.dealer.showCard && !name2Set ? "<input type='text' name='player2Name'>" : "" }
			${ !warGame.dealer.showCard  ? "<br />" : "" }
			${ warGame.dealer.showCard  ? "" : "<input type='submit' name='draw' value='Draw and Start Game'>" }
			${ warGame.dealer.showCard && !warGame.dealer.timeOfWar ? "<input type='submit' name='draw' value='Draw'>" : "" }
			${ warGame.dealer.timeOfWar  ? "<input type='submit' name='goToWar' value='Show War Card'>" : "" }
			<input type="submit" name="test" value="Stack Deck and Test">
			<input type="submit" name="reset" value="RESET">
		</form>
	</div>
</div>	
</body>
</html>