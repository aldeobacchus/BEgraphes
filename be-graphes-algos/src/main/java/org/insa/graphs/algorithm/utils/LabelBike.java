package org.insa.graphs.algorithm.utils;

import org.insa.graphs.model.*;
import org.insa.graphs.model.RoadInformation.RoadType;
import org.insa.graphs.algorithm.shortestpath.*;
//import org.insa.graphs.algorithm.AbstractInputData;


public class LabelBike extends Label implements Comparable<Label> {
	
	
	public LabelBike(Node current_Sommet, float cost, Arc pere, ShortestPathData data) {
		super(current_Sommet,cost,pere);
	}
	
	
	@Override
	public void setCost(float newcost) {
		if (this.pere.getRoadInformation().getType() == RoadType.MOTORWAY) {
			this.cost = 10000;
		}else {
			this.cost = newcost;
		}
	}
	
}