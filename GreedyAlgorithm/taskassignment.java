package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class taskassignment {
    
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks){

        ArrayList<ArrayList<Integer>> pairedTasks = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, ArrayList<Integer>> taskDurationToIndices = getTaskDurationToIndices(tasks);

        ArrayList<Integer> sortedTask = tasks;
        Collections.sort(sortedTask);

        int i = 0, j = tasks.size()-1;

        while(j > i){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int member1 = sortedTask.get(i);
            int member2 = sortedTask.get(j);
           
            ArrayList<Integer> getIndices1 = taskDurationToIndices.get(member1);
            int indexOfMember1 = getIndices1.remove(0);

            ArrayList<Integer> getIndices2 = taskDurationToIndices.get(member2);
            int indexOfMember2 = getIndices2.remove(0);

            temp.add(indexOfMember1);
            temp.add(indexOfMember2);
            pairedTasks.add(temp);
            i++;
            j--;
        }

        return pairedTasks;
    }

    public HashMap<Integer, ArrayList<Integer>> getTaskDurationToIndices(ArrayList<Integer> tasks) {
        HashMap<Integer, ArrayList<Integer>> taskDurationToIndices = new HashMap<Integer, ArrayList<Integer>>();

        for(int i = 0; i < tasks.size(); i++){
            int task = tasks.get(i);

            if(taskDurationToIndices.containsKey(task)){
                taskDurationToIndices.get(task).add(i);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                taskDurationToIndices.put(task, temp);
            }
        }

        return taskDurationToIndices;
    }

    public static void main(String[] args) {
        taskassignment obj = new taskassignment();
        ArrayList<ArrayList<Integer>> result = obj.taskAssignment(3, new ArrayList<>(Arrays.asList(1, 3, 5 , 3, 1, 4)));
        System.out.println(result);
    }
}
