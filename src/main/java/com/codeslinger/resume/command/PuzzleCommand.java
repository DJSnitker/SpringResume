package com.codeslinger.resume.command;

import com.codeslinger.resume.command.CommandInterface;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import com.codeslinger.resume.puzzle.PositionalEvaluator;

@Service
public class PuzzleCommand implements CommandInterface{

	private HashMap<String,PositionalEvaluator> comparisonAggregate;
	private String[] rows;

	public String execute( String command, String dynamicData ){
		dynamicData = dynamicData.substring(27,dynamicData.length());
		rows = dynamicData.split("\n");
		comparisonAggregate = buildAggregate();
		analyzeComparisonTable();
		return buildResponse();
	}

	public HashMap<String,PositionalEvaluator> buildAggregate(){
    	HashMap<String,PositionalEvaluator> comparisonAggregate = new HashMap<String,PositionalEvaluator>();
		for(int i = 0; i < rows[0].length(); i++){	
			comparisonAggregate.put( rows[0].substring(i,i+1), new PositionalEvaluator( rows[0].substring(i,i+1), rows.length - 1 ) );
		}
		return comparisonAggregate;
	}

	public void analyzeComparisonTable(){
		for(int vertical = 1; vertical < rows.length; vertical++){
			String verticalKey = rows[0].substring(vertical-1, vertical);
			for(int horizontal = 1; horizontal < rows[vertical].length(); horizontal++){
				String horizontalKey = rows[0].substring(horizontal-1, horizontal);
				String comparisonSign = rows[vertical].substring(horizontal,horizontal+1);
				if( comparisonSign.equals(">") ){
					comparisonAggregate.get( verticalKey ).makeGreaterThan( comparisonAggregate.get( horizontalKey ) );
				}
				if( comparisonSign.equals("<") ){
					comparisonAggregate.get( verticalKey ).makeLessThan( comparisonAggregate.get( horizontalKey ) );
				}
				if( comparisonSign.equals("=") || vertical == horizontal ){
					comparisonAggregate.get( verticalKey ).equalize( comparisonAggregate.get( horizontalKey ) ); 
				}
			}
		}
	}

	public String buildResponse(){
		String result = " " + rows[0] + "\n";
		for(int vertical = 0; vertical < rows[0].length(); vertical++){
			String currentRowTitle = rows[0].substring(vertical, vertical + 1);
			result += currentRowTitle;			
			for(int horizontal = 0; horizontal < rows[0].length(); horizontal++){
				String currentColumnTitle = rows[0].substring(horizontal, horizontal+1);
				result+= comparisonAggregate.get( currentRowTitle ).getSignOfComparison(currentColumnTitle)	;
			}
			result+= ( vertical != rows[0].length()-1 ? "\n" : "" );
		}
		return result;
	}
}
