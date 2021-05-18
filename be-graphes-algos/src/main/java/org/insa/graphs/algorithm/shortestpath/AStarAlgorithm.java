package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.utils.*;
import org.insa.graphs.model.*;


public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected Label newLabel(Node sommet, float cost, Arc pere, ShortestPathData data) {
    	return new LabelStar(sommet, cost, pere, data);
    }
    
}
