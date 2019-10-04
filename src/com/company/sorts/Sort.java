package com.company.sorts;

public abstract class Sort {
    protected int moves;
    protected int evaluates;
    protected long time;

   abstract void doSort(int array[]);

   public int getMoves(){
       return moves;
   }
   public int getEvaluates(){
       return evaluates;
   }
    public long getTime() {
        return time;
    }
}