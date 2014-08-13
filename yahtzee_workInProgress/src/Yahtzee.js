

function scoreChoices(valueScoreCouples){
	$('#scoringOptionsRight').empty();
	var table = $('<table border = "1"></table>');
	var headerRow = $('<tr></tr>');
	var headerColNameHand =$('<td></td>');
	var headerColNameScore =$('<td></td>');
	var headerColNameHandText = "If you scored it as... ";
	var headerColNameScoreText = "It would be worth... ";
	var headerColNameOption =$('<td></td>')
	var headerColNameOptionText = "Just do it! "
	headerColNameHand.append(headerColNameHandText);
	headerRow.append(headerColNameHand);
	headerColNameScore.append(headerColNameScoreText);
	headerRow.append(headerColNameScore);
	headerColNameOption.append(headerColNameOptionText);
	headerRow.append(headerColNameOption);
	table.append(headerRow);
	for (var i = 0; i < valueScoreCouples.length; i++){
		var row = $('<tr></tr>');
		var handName = $('<td></td>');
		var scoreAmt = $('<td></td>');
		var okButton = $('<td></td>');
		row.append(handName);
		row.append(scoreAmt);
		row.append(okButton);
		handName.append(valueScoreCouples[i][0]);
		scoreAmt.append(valueScoreCouples[i][1]);
		var button = document.createElement("input")
    	button.type = "submit"
    	button.value = "Count it"
		okButton.append(button);
		okButton.click(function(){
			$('okButton').hide;
		})

		table.append(row);
	}
	$('#scoringOptionsRight').append(table);
}

function loadScoreBoard(){
	var table = $('<table border = "1"></table>');
	var headerRow = $('<tr></tr>');
	var handTypes = $('<td></td>');
	var playerOneCol = $('<td></td>');
	var playerTwoCol = $('<td></td>');
	var handTypesText = "Hand";
	var playerOneColText = "Katniss";
	var playerTwoColText = "Cato";
	handTypes.append(handTypesText);
	playerOneCol.append(playerOneColText);
	playerTwoCol.append(playerTwoColText);
	headerRow.append(handTypes);
	headerRow.append(playerOneCol);
	headerRow.append(playerTwoCol);
	table.append(headerRow);
	var acesRow = $('<tr></tr>');
	var acesCol = $('<td></td>');
	var acesRowText = "Aces"
	acesCol.append(acesRowText);
	var playerOneAces = $('<td></td>');
	var playerTwoAces = $('<td></td>');
	acesRow.append(acesCol);
	acesRow.append(playerOneAces);
	acesRow.append(playerTwoAces);
	var twosRow = $('<tr></tr>');
	var twosCol = $('<td></td>');
	var twosRowText = "Twos"
	twosCol.append(twosRowText);
	var playerOneTwos = $('<td></td>');
	var playerTwoTwos = $('<td></td>');
	twosRow.append(twosCol);
	twosRow.append(playerOneTwos);
	twosRow.append(playerTwoTwos);
	var threesRow = $('<tr></tr>');
	var threesCol = $('<td></td>');
	var threesRowText = "Threes"
	threesCol.append(threesRowText);
	var playerOneThrees = $('<td></td>');
	var playerTwoThrees = $('<td></td>');
	threesRow.append(threesCol);
	threesRow.append(playerOneThrees);
	threesRow.append(playerTwoThrees);
	var foursRow = $('<tr></tr>');
	var foursCol = $('<td></td>');
	var foursRowText = "Fours"
	foursCol.append(foursRowText);
	var playerOneFours = $('<td></td>');
	var playerTwoFours = $('<td></td>');
	foursRow.append(foursCol);
	foursRow.append(playerOneFours);
	foursRow.append(playerTwoFours);
	var fivesRow = $('<tr></tr>');
	var fivesCol = $('<td></td>');
	var fivesRowText = "Fives"
	fivesCol.append(fivesRowText);
	var playerOneFives = $('<td></td>');
	var playerTwoFives = $('<td></td>');
	fivesRow.append(fivesCol);
	fivesRow.append(playerOneFives);
	fivesRow.append(playerTwoFives);
	var sixesRow = $('<tr></tr>');
	var sixesCol = $('<td></td>');
	var sixesRowText = "Sixes"
	sixesCol.append(sixesRowText);
	var playerOneSixes = $('<td></td>');
	var playerTwoSixes = $('<td></td>');
	sixesRow.append(sixesCol);
	sixesRow.append(playerOneSixes);
	sixesRow.append(playerTwoSixes);
	var toakRow = $('<tr></tr>');
	var toakCol = $('<td></td>');
	var toakRowText = "Three of a kind"
	toakCol.append(toakRowText);
	var playerOneToak = $('<td></td>');
	var playerTwoToak = $('<td></td>');
	toakRow.append(toakCol);
	toakRow.append(playerOneToak);
	toakRow.append(playerTwoToak);
	var foakRow = $('<tr></tr>');
	var foakCol = $('<td></td>');
	var foakRowText = "Four of a kind"
	foakCol.append(foakRowText);
	var playerOneFoak = $('<td></td>');
	var playerTwoFoak = $('<td></td>');
	foakRow.append(foakCol);
	foakRow.append(playerOneFoak);
	foakRow.append(playerTwoFoak);
	var fhRow = $('<tr></tr>');
	var fhCol = $('<td></td>');
	var fhRowText = "Full house"
	fhCol.append(fhRowText);
	var playerOnefh = $('<td></td>');
	var playerTwofh = $('<td></td>');
	fhRow.append(fhCol);
	fhRow.append(playerOnefh);
	fhRow.append(playerTwofh);
	var ssRow = $('<tr></tr>');
	var ssCol = $('<td></td>');
	var ssRowText = "Small Straight"
	ssCol.append(ssRowText);
	var playerOness = $('<td></td>');
	var playerTwoss = $('<td></td>');
	ssRow.append(ssCol);
	ssRow.append(playerOness);
	ssRow.append(playerTwoss);
	var lsRow = $('<tr></tr>');
	var lsCol = $('<td></td>');
	var lsRowText = "Long Straight"
	lsCol.append(lsRowText);
	var playerOnels = $('<td></td>');
	var playerTwols = $('<td></td>');
	lsRow.append(lsCol);
	lsRow.append(playerOnels);
	lsRow.append(playerTwols);
	var yahtzeeRow = $('<tr></tr>');
	var yahtzeeCol = $('<td></td>');
	var yahtzeeRowText = "Yahtzee"
	yahtzeeCol.append(yahtzeeRowText);
	var playerOneyahtzee = $('<td></td>');
	var playerTwoyahtzee = $('<td></td>');
	yahtzeeRow.append(yahtzeeCol);
	yahtzeeRow.append(playerOneyahtzee);
	yahtzeeRow.append(playerTwoyahtzee);
	table.append(acesRow);
	table.append(twosRow);
	table.append(threesRow);
	table.append(foursRow);
	table.append(fivesRow);
	table.append(sixesRow);
	table.append(foakRow);
	table.append(toakRow);
	table.append(lsRow);
	table.append(ssRow);
	table.append(fhRow);
	table.append(yahtzeeRow);
	$('.scoreBoard').append(table);
}



function init(){
	loadScoreBoard();
}

function playGame(){
	var isFinished = false;
	var playerOne = {name: "playerOne"};
	var playerTwo = {name: "playerTwo"};
	while (!isFinished){
		turn(playerOne);
		scoreUpdate();
		isFinished = isFinishedCheck();
		if (isFinished) break;
		turn(playerTwo);
		scoreUpdate();
		isFinished = isFinishedCheck();
	}
}

function displayRollResult(rollResult){
		var rollValue = handValues(rollResult);
		var diceArray = rollResult.toString();

/*		$().each(function (index, element){

		})*/

		// From Adam : Use jQuery to select elements and modify them

		$(".dieRolled").each( function(index, element){
			$(element).attr("num", rollResult[index]);
		});


		for (var i = 0; i < rollValue.length; i++){
			rollValue[i].score = handScore(rollResult, rollValue[i]);
		}

		var valueArray = rollValue.toString();
		
		var valueScoreCouples =[];
		for (var i = 0; i < rollValue.length; i++){
			valueScoreCouples[i] = [rollValue[i].name, rollValue[i].score];
		}
		scoreChoices(valueScoreCouples);
		return rollResult;
};

function turn(currentPlayer){
	var nonKeepers = [0,1,2,3,4];
	var keepers = [];
	var rollResult = rollDice(nonKeepers, keepers);
	displayRollResult(rollResult);
	//wait
	keepers = selectKeepers(rollResult);
	nonKeepers = selectNonKeepers(nonKeepers, keepers);
	rollResult = rollDice(nonKeepers, keepers);
	displayRollResult(rollResult);
	selectKeepers(rollResult);
	rollResult = rollDice(nonKeepers, keepers);
	displayScoreOptions(rollResult);
	selectScoreOption();
}


function selectKeeper(){
	/*console.log("clicked");
	$(this).click( function(){
		$(this).attr("lock", "on") ? $(this).attr("lock", "off") : $(this).attr("lock", "on");
	});*/

	if ($(this).attr("lock") === "off"){
		$(this).attr("lock", "on");
	} else {
		$(this).attr("lock", "off");
	}


}
	/*$('.dieOne button').click(function(){
		if ($('.dieOne').attr('locked')==='false') {
			$('.dieOne').attr('locked', 'true');
		} else {
			$('.dieOne').attr('locked', 'false');
		}
	})
	$('.dieTwo button').click(function(){
		if ($('.dieTwo').attr('locked')==='false') {
			$('.dieTwo').attr('locked', 'true');
		} else {
			$('.dieTwo').attr('locked', 'false');
		}
	})
	$('.dieThree button').click(function(){
		if ($('.dieThree').attr('locked')==='false') {
			$('.dieThree').attr('locked', 'true');
		} else {
			$('.dieThree').attr('locked', 'false');
		}
	})
	$('.dieFour button').click(function(){
		if ($('.dieFour').attr('locked')==='false') {
			$('.dieFour').attr('locked', 'true');
		} else {
			$('.dieFour').attr('locked', 'false');
		}
	})
	$('.dieFive button').click(function(){
		if ($('.dieFive').attr('locked')==='false') {
			$('.dieFive').attr('locked', 'true');
		} else {
			$('.dieFive').attr('locked', 'false');
		}
	})
	return keepers;
}*/

function scoreUpdate(currentPlayer, selectedScoreOption){
	placeScore(currentPlayer, selectedScoreOption);
	updateTotal();
	removeOptionFromBoard(currentPlayer, selectedScoreOption);
}

function placeScore(currentPlayer, selectedScoreOption){
	var columnToBeUpdated = currentPlayer;
	var rowToBeUpdated = selectedScoreOption.name;
	selectedScoreOption.points
}

/*function isFinishedCheck(){
	bothPlayersBoardsAreFull ? return true: return false;
}*/

function containFunc(){
	$('.rollButton button').click(displayRollResult);
}

$( document ).ready(function() {

$('.dieRolled1').click(selectKeeper);
$('.dieRolled2').click(selectKeeper);
$('.dieRolled3').click(selectKeeper);
$('.dieRolled4').click(selectKeeper);
$('.dieRolled5').click(selectKeeper);
$('.rollButton').click(turn.rollAllDice);

});