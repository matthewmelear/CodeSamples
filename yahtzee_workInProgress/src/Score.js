var score = {
	function handValues(roll){
		var result = [];
		var mostOfAKind = Math.max.apply(Math, roll);
		if (mostOfAKind >== 2)												{result.push({name:"A Pair!"});
			if (mostOfAKind >== 3)											{result.push({name:"Three of a Kind!"});
				if (mostOfAKind >== 4)										{result.push({name:"Four of a Kind!"});
					if (mostOfAKind === 5)	                				{result.push({name:"YAHTZEE!"});}}
				else if (roll.filter(function(e){return e === 2}).length === 1)
																			{result.push({name:"Full House!"});}}
			if (roll.filter(function(e){return e >== 2}).length ===2)		{result.push({name:"Two Pair!"})};}	
		

		if (roll.filter(function(e){ return e === 2;}).length === 0 
		     && (roll[0] === 0 || roll[5] === 0))							{result.push({name:"Long Straight!"});}
		if (roll[2] !== 0 && roll [3] !== 0 &&
	 		(roll[0] !== 0 && roll [1] !== 0) ||
			(roll[4]] !== 0 && roll [5] !== 0))								{result.push({name:"Short Straight!"});}

		if (roll[0] > 0)													{result.push({name:"Aces"});}
		if (roll[1] > 0)													{result.push({name:"Twos"});}
		if (roll[2] > 0)													{result.push({name:"Threes"});}
		if (roll[3] > 0)													{result.push({name:"Fours"});}
		if (roll[4] > 0)													{result.push({name:"Fives"});}
		if (roll[5] > 0)													{result.push({name:"Sixes"});}
		return result;
	}

	function diceSummer(rollArray){
		var total = 0;
		var scorePerPlace = rollArray.map(function(numOfKind, index){return numOfKind * index+1});
		$.each(scorePerPlace, function(){total += this;});
		return total;
	}

	function handScore(rollArray, value){
		var score = 0;
		switch (value["name"]){
			case "YAHTZEE!": 			{score = 50;}
			case "Four of a Kind!": 	{score = diceSummer(rollArray);}
			case "Three of a Kind!": 	{score = diceSummer(rollArray);}
			case "Full House!": 		{score = 25;}
			case "Long Straight!": 		{score = 30;}
			case "Short Straight!": 	{score = 40;}
			case "Two Pair!": 			{score = (rollArray.indexOf(2)+1) * 2 + (rollArray.lastIndexOf(2)+1) * 2;}
			case "A Pair!": 			{score = (rollArray.lastIndexOf(2)+1) * 2;}
			case "Aces": 				{score = diceSummer(rollArray.map(function(e, i){return i === 0 ? e : 0}));}
			case "Twos": 				{score = diceSummer(rollArray.map(function(e, i){return i === 1 ? e : 1}));}
			case "Threes": 				{score = diceSummer(rollArray.map(function(e, i){return i === 2 ? e : 2}));}
			case "Fours": 				{score = diceSummer(rollArray.map(function(e, i){return i === 3 ? e : 3}));}
			case "Fives": 				{score = diceSummer(rollArray.map(function(e, i){return i === 4 ? e : 4}));}
			case "Sixes": 				{score = diceSummer(rollArray.map(function(e, i){return i === 5 ? e : 5}));}
			case "Chance": 				{score = diceSummer(rollArray);}
		}
		return score;
	}
}