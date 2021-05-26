package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.utils.*;
import org.insa.graphs.model.*;


public class BikeAlgorithm extends DijkstraAlgorithm {

    public BikeAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected Label newLabel(Node sommet, float cost, Arc pere, ShortestPathData data) {
    	return new LabelStar(sommet, cost, pere, data);
    }
    
}
