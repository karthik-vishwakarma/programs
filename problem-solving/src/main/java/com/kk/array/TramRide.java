package com.kk.array;

import static java.lang.Math.min;

public class TramRide {

    /*
     * Problem
     * A city has N Tram stations numbered from 1 to N  that are connected to one another and form a circle. You are given an array ticket_cost  where ticket_cost[i] is the cost of a ticket between the stops number i and (i + 1) % N. The Tram can travel in both directions i.e. clockwise and anti-clockwise.
     * Return the minimum cost to travel between the given start and finish station.
     * You are given an integer N where N represents the total number of the tram stations, an integer start which represents the start station, and an integer finish which represents the finish station. You are given an array of positive integers  ticket_cost where ticket_cost[i] represents the ticket cost between the station number i and (i + 1) % N.
     * Task : Determine the minimum cost to travel between the given start and finish station.
     * Example
     * Assumptions
     * N = 4
     * start = 1
     * finish = 4
     * ticket_cost = [1, 2, 2, 4 ]
     * Approach
     * path1 -> 1------1-----> 2 -------2------> 3 -------2------> 4 . => 1+2+2 => 5
     * path2 -> 1------4------>4 . => 4
     * Path2 will give the minimum cost. Therefore, return 4.
     */

    public static void main(String[] args) {

        //15
        //1
        //8
        //14 20 7 14 21 18 13 2 7 1 5 16 5 10 14
        System.out.printf("MIN DISTANCE ::" + solve(15, 1, 8, new int[]{14, 20, 7 ,14, 21, 18, 13, 2, 7, 1, 5, 16, 5, 10, 14}));
    }

    static long solve(int N, int start, int finish, int[] Ticket_cost) {
        if (finish < start) {
            int temp = finish;
            finish = start;
            start = temp;
        }
        long sum1 = 0;
        long sum2 = 0;
        for (int i = finish - 1; i < N + start - 1; i++) { //3 , N=4, stat =3
            int j = i % N;
            sum1 += Ticket_cost[j];
        }


        for (int j = start - 1; j < finish - 1; j++) {
            sum2 += Ticket_cost[j];
        }
        System.out.println(sum1);
        System.out.println(sum2);
        return min(sum2, sum1);
    }
}
