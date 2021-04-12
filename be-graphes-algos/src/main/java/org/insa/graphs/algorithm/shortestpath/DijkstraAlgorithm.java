package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.utils.*;
import org.insa.graphs.model.*;
import java.util.HashMap;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }

    
    
    @Override
    protected ShortestPathSolution doRun() {
        final ShortestPathData data = getInputData();
        ShortestPathSolution solution = null;
        
        //Pour initiqliser le grqphe et associer un label q chaque noeud 
        //on vq parcourir l'ensemble du graph et faire un hashmap put(noeud,Label)
        HashMap<Node, Label> etiquettes = new HashMap<Node, Label>();
        
        for (Node n : data.getGraph().getNodes()) {
        	etiquettes.put(n, new Label(n, Float.POSITIVE_INFINITY,null));
        }
        
        //On déclare le tas binaire qui va contenir les label parcouru
        BinaryHeap<Label> tas = new BinaryHeap<>();
        
        //On declare le cout a l'origine a 0 et on l'insere dans le tas
        etiquettes.get(data.getOrigin()).setCost(0);
        tas.insert(etiquettes.get(data.getOrigin()));
        
        //tant qu'il existe des sommets non marqués
        while ( tas.isEmpty() == false) {
        	
        }
        
        return solution;
    }

}
