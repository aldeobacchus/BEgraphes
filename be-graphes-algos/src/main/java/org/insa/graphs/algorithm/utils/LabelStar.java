package org.insa.graphs.algorithm.utils;

import org.insa.graphs.model.*;
import org.insa.graphs.algorithm.shortestpath.*;
import org.insa.graphs.algorithm.AbstractInputData;


public class LabelStar extends Label implements Comparable<Label> {
	
	private float valuedCost;
	
	public LabelStar(Node current_Sommet, float cost, Arc pere, ShortestPathData data) {
		super(current_Sommet,cost,pere);
		
		float distance = (float) Point.distance(current_Sommet.getPoint(), data.getDestination().getPoint());
		
		if (data.getMode() == AbstractInputData.Mode.LENGTH) {
			this.valuedCost = distance;
		}else{
			float vitesse = (data.getGraph().getGraphInformation().getMaximumSpeed() * 1000) / 3600;
			this.valuedCost = distance / vitesse;
		}
	}
	
	
	@Override
	public float getTotalCost() {
		return this.getCost()+valuedCost;
	}
	
}