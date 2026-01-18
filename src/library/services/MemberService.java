package library.services;

import library.entities.Member;

import java.util.Scanner;

public class MemberService {
    Scanner sc = new Scanner(System.in);

    public void viewMembers(Member[] members){
        for(int i = 0; i<members.length; i++){
            members[i].displayInfo();
        }
    }

    public void removeMember(Member [] member){
        System.out.print("enter the ID of the member : ");
        int id = sc.nextInt();
        for(int i=0; i<member.length; i++){
            if(member[i].getId() == id){
                member[i] = null;
                return;
            }
        }
        System.out.println("invalid ID");
    }
}
