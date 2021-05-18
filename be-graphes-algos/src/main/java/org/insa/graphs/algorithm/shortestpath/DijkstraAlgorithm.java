package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.utils.*;
import org.insa.graphs.model.*;
import org.insa.graphs.algorithm.AbstractSolution.Status;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

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
        	etiquettes.put(n, newLabel(n, Float.POSITIVE_INFINITY,null, data));
        }
        
        //On déclare le tas binaire qui va contenir les label parcouru
        BinaryHeap<Label> tas = new BinaryHeap<>();
        
        //On declare le cout a l'origine a 0 et on l'insere dans le tas
        etiquettes.get(data.getOrigin()).setCost(0);
        tas.insert(etiquettes.get(data.getOrigin()));
        notifyOriginProcessed(data.getOrigin());//observer
        
        boolean end = false;// true si on est arrivé a destination
        
        //tant qu'il existe des sommets non marqués
        while ( tas.isEmpty() == false && !end) {
        	Label min = tas.findMin();//Extraction du minimum du tas
        	min.setMark();//Marquage du minimum
        	notifyNodeReached(min.getNode());
        	tas.remove(min);
        	
        	if (min.getNode() == data.getDestination()){
        		end = true;
        		notifyDestinationReached(min.getNode());
        		continue;
        	}
        	
        	for (Arc arc : min.getNode().getSuccessors()) {//Pour tout les y successeurs de x
        		
        		if (!data.isAllowed(arc)) {//on saute cette iteration si le chemin qu'on compte emprunter n'est pas autorisé
        			continue;
        		}
        		
        		Node succ = arc.getDestination();
        		Label labelSucc = etiquettes.get(succ);
        		notifyNodeReached(succ);
        		
        		if (!labelSucc.getMark()) {//si ces successeurs sont non marqués
            	
        			float newCost = (float) (min.getCost()+data.getCost(arc));

        			if (newCost < labelSucc.getCost()) {
        				
        				labelSucc.setCost(newCost);
        				tas.insert(labelSucc);
        				labelSucc.setFather(arc);
        			}
        		}
        	}
        	
        }
        
        Label dest = etiquettes.get(data.getDestination());
        
        //on test si la destination a un predecesseur ou non
        if (dest.getFather() == null) {	
        	solution = new ShortestPathSolution(data, Status.INFEASIBLE);
        }
        else{//on va creer la liste a partir des peres puis l'inverser
        	ArrayList<Arc> ListArcPere = new ArrayList<Arc>();
        	Arc arc =  dest.getFather();
        	
        	while (arc != null) {
        		ListArcPere.add(arc);
        		arc = etiquettes.get(arc.getOrigin()).getFather();
        	}
        	
        	//on retourne la liste
        	Collections.reverse(ListArcPere);
        	
        	solution = new ShortestPathSolution(data, Status.OPTIMAL, new Path(data.getGraph(), ListArcPere));
        }
        
        
        return solution;
    }
    
    protected Label newLabel(Node sommet, float cost, Arc pere,ShortestPathData data) {
    	return new Label(sommet, cost, pere);
    }
	
}
