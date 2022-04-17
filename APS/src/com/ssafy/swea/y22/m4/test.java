package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class test {
 
    static class Person implements Comparable<Person> {
        int r, c, time; // 위치, 나가는데 걸린 시간
 
        public Person(int r, int c, int time) {
            super();
            this.r = r;
            this.c = c;
            this.time = time;
        }
 
        @Override
        public int compareTo(Person o) {
            return this.time - o.time;
        }
 
    }
 
    static class Stair {
        int r, c, height; // 위치, 계단 높이
        ArrayList<Person> nowPeople; // 지금 계단에 있는 사람들
 
        public Stair(int r, int c, int height) {
            super();
            this.r = r;
            this.c = c;
            this.height = height;
        }
    }
 
    static int[][] map;
    static int n, ans;
    static ArrayList<Person> people;
    static ArrayList<Stair> stairs;
    static boolean[] sel; // 사람 선택 여부 표시하기 위한 배열
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            people = new ArrayList<>();
            stairs = new ArrayList<>();
 
            // 입력
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        people.add(new Person(i, j, 0)); // 사람 목록
                    } else if (map[i][j] > 1) {
                        stairs.add(new Stair(i, j, map[i][j])); // 계단 목록
                    }
                }
            }
             
            sel = new boolean[people.size()];
            ans = Integer.MAX_VALUE; 
             
            // 부분집합으로 그룹을 2개로 나눠 계단으로 보낸다.
            powerset(people.size(), 0);
 
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        } // tc close
        System.out.println(sb);
    } // main close
 
    private static void powerset(int n, int k) {
        Stair stair1 = stairs.get(0);
        Stair stair2 = stairs.get(1);
 
        if (n == k) {
            stair1.nowPeople = new ArrayList<>(); // 계단마다 목록을 만들어준다
            stair2.nowPeople = new ArrayList<>();
 
            // 사람들 계단으로 보내기
            for (int i = 0; i < sel.length; i++) {
                if (sel[i])
                    stair1.nowPeople.add(people.get(i));
                else
                    stair2.nowPeople.add(people.get(i));
            }
 
            int size1 = stair1.nowPeople.size();
            int size2 = stair2.nowPeople.size();
 
            // 일단 사람들이 계단까지 걸리는 시간 + 1 을 계단 내려가는 시간으로 구해놓는다.
            for (int i = 0; i < size1; i++) {
                stair1.nowPeople.get(i).time = Math.abs(stair1.nowPeople.get(i).r - stair1.r)
                        + Math.abs(stair1.nowPeople.get(i).c - stair1.c) + 1;
            }
            for (int i = 0; i < size2; i++) {
                stair2.nowPeople.get(i).time = Math.abs(stair2.nowPeople.get(i).r - stair2.r)
                        + Math.abs(stair2.nowPeople.get(i).c - stair2.c) + 1;
            }
 
            // 계단까지 걸리는 시간이 작은 순으로 정렬(먼저 도착하는 사람부터 나가도록)
            Collections.sort(stairs.get(0).nowPeople);
            Collections.sort(stairs.get(1).nowPeople);
 
            // 반복문을 돌린다.
            // 한 사람이 계단에 도착한 시간(time)이 세번째 앞의 사람의 time+height보다 크거나 같으면 대기없이 내려갈 수 있음 ->
            // time+height가 최종 시간
            // 작으면 (time+height)+height만큼 걸림
            // 두 계단에서 마지막으로 나온 사람의 걸린 시간 중 최소 시간이 답
 
            int tmp1 = 0;
            int tmp2 = 0;
 
            // 계단에 있는 사람이 3명보다 적으면 가장 마지막에 있는 사람이 내려간 시간+계단 높이가 그 계단을 나오는데 걸리는 시간
            if (size1 <= 3) {
                if (!stair1.nowPeople.isEmpty())
                    tmp1 = stair1.nowPeople.get(size1 - 1).time + stair1.height;
            } else { // 3명보다 많으면, 위의 규칙 적용, 이때, 더 오래 걸리는 시간을 그 사람의 시간으로 바꾸고 연산
                for (int i = 3; i < size1; i++) {
                    stair1.nowPeople.get(i).time = Math.max(stair1.nowPeople.get(i).time,
                            stair1.nowPeople.get(i - 3).time + stair1.height);
                    tmp1 = stair1.nowPeople.get(i).time + stair1.height;
                }
            }
 
            if (size2 <= 3) {
                if (!stair2.nowPeople.isEmpty())
                    tmp2 = stair2.nowPeople.get(size2 - 1).time + stair2.height;
            } else {
                for (int i = 3; i < size2; i++) {
                    stair2.nowPeople.get(i).time = Math.max(stair2.nowPeople.get(i).time,
                            stair2.nowPeople.get(i - 3).time + stair2.height);
                    tmp2 = stair2.nowPeople.get(i).time + stair2.height;
                }
 
            }
 
            int tmp = Math.max(tmp1, tmp2);
            ans = Math.min(ans, tmp);
            return;
        }
 
        if (k >= people.size())
            return;
 
        sel[k] = false;
        powerset(n, k + 1);
        sel[k] = true;
        powerset(n, k + 1);
 
    }
 
}