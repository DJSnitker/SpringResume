package com.codeslinger.resume.puzzle;

import java.util.HashMap;

public class PositionalEvaluator{

	private static int comparisonUpdateCount;
	private static int maxComparisonUpdates;
	private String charValue;
	
	private HashMap<String, PositionalEvaluator> lessThanMe;
	private HashMap<String, PositionalEvaluator> moreThanMe;
	private HashMap<String, PositionalEvaluator> equalToMe;

	public PositionalEvaluator( String CharacterValue, int columns ){
		charValue = CharacterValue;		
		maxComparisonUpdates = (columns * columns);
		comparisonUpdateCount = 0;
		lessThanMe = new HashMap<String, PositionalEvaluator>();
		moreThanMe = new HashMap<String, PositionalEvaluator>();
		equalToMe = new HashMap<String, PositionalEvaluator>();
	}

	public String getCharacterKey(){
		return charValue;
	}

	public void makeGreaterThan( PositionalEvaluator other){
		if( !lessThanMe.keySet().contains(other.getCharacterKey()) && comparisonUpdateCount < maxComparisonUpdates ){
			comparisonUpdateCount++;
			lessThanMe.put(other.getCharacterKey(),other);
			for( String cascade: moreThanMe.keySet() ){
				moreThanMe.get(cascade).makeGreaterThan(other);
			}
			for( String cascade: equalToMe.keySet() ){
				equalToMe.get(cascade).makeGreaterThan(other);
			}
			other.makeLessThan(this);
		}
	}

	public void makeLessThan( PositionalEvaluator other){
		if( !moreThanMe.keySet().contains(other.getCharacterKey()) && comparisonUpdateCount < maxComparisonUpdates ){
			comparisonUpdateCount++;
			moreThanMe.put(other.getCharacterKey(),other);
			for( String cascade: lessThanMe.keySet() ){
				lessThanMe.get(cascade).makeLessThan(other);
			}
			for( String cascade: equalToMe.keySet() ){
				equalToMe.get(cascade).makeLessThan(other);
			}
			other.makeGreaterThan(this);
		}
	}

	public void equalize( PositionalEvaluator other ){
		if( !equalToMe.keySet().contains(other.getCharacterKey()) && comparisonUpdateCount < maxComparisonUpdates ){
			comparisonUpdateCount++;
			equalToMe.put(other.getCharacterKey(),other);
			for( String cascade: equalToMe.keySet() ){
				equalToMe.get(cascade).equalize(other);
			}
			other.equalize(this);
		}
	}

	public String getSignOfComparison( String targetKey ){
		if( moreThanMe.keySet().contains(targetKey)){
			return "<";
		}
		if( lessThanMe.keySet().contains(targetKey)){
			return ">";
		}
		return "=";
	}
 
}
