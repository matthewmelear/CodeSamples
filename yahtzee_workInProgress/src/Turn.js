var turn = {
	var rollsRemaining = 3;
	var rollArray = [];

	function rollAllDice(){
		if (rollsRemaining === 3){
			rollArray = [0, 0, 0, 0, 0, 0];
		}
		for (i = 1; i < 6; i++){
			if ($('.dieRolled' + i).attr("lock") === "off")){
				//animateDie(i);
				rollDie(i);
			}
		}
	}

	function rollDie(number){
		var result = Math.floor(Math.random()*6)+1;
		if ($('.dieRolled' + number).attr("lock") === "off"){
			$('.dieRolled' + number).attr("num") === result;
			rollArray[result - 1]++;
		}
		if (number === 5) {
			rollsRemaining--;
			handValues = hand.handValues(rollArray);
			for (i = 0; i < handValues.length; i++){
				value = handScore(rollArray, handValues[i])
			}
		}
	}

	function prepDie(rollArray){
		rollArray.sort();
	}

	
}