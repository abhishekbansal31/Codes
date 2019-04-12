import java.util.*;
class Trie{
	HashMap<Character,Trie> hm;
	boolean isWord;
	Trie(){
		hm=new HashMap<Character,Trie>();
		isWord=false;
	}
}
public class TrieDS {
	Trie root;
	TrieDS(){
		root=new Trie();
	}
	void insert(String s) {
		Trie temp=root;
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);	
			if(temp.hm.isEmpty() || !temp.hm.containsKey(ch)) {
				Trie temp2=new Trie();
				temp.hm.put(ch, temp2);
				temp=temp2;
			}
			else {
				temp=temp.hm.get(ch);
			}
		}
		temp.isWord=true;
	//	}
	}
	void delete(Trie root,String s) {
		Trie temp=root;
		char ch=s.charAt(0);
		int n=s.length();
		if(temp==null || !temp.hm.containsKey(ch)) {
			System.out.println("No such element exist");
		}
		else if(n>1){
			delete(temp.hm.get(ch),s.substring(1, s.length()));
		}
		//else{ } 

		Trie temp2=temp.hm.get(ch);
		if(n==1){
			if(temp2!=null) {
				temp2.isWord=false;
				if(temp2.hm.isEmpty()) {
					temp.hm.remove(ch);
				}
			}
		}
		else {
			if(temp2!=null) {
				if(temp2.hm.isEmpty() && temp2.isWord==false) {
					temp.hm.remove(ch);
				}
			}
		}
	}
	boolean search(String s ) {
		char ch;
		int n=s.length();
		Trie temp=root;
		for(int i=0;i<n;i++) {
			ch=s.charAt(i);
			if(temp!=null && temp.hm.containsKey(ch)) {
				temp=temp.hm.get(ch);
			}
			else {
				return false;
			}
		}
		if(temp!=null && temp.isWord)
			return true;
		return false;
	}
	void display(Trie node,String s) {
		if(node.isWord==true) {
			System.out.println(s);
		}
		Iterator<Character> itr = node.hm.keySet().iterator();
		while(itr.hasNext()) {
			char ch=itr.next();
			display(node.hm.get(ch), s.concat(String.valueOf(ch)));
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		TrieDS tr=new TrieDS();
		while(t-->0) {
			System.out.println("1. Insert\n2. Delete\n3. Search\n4. Display");
			int n=sc.nextInt();
			sc.nextLine();
			if(n==1) {
				String s = sc.nextLine();
				tr.insert(s);
			}
			else if(n==2) {
				String s = sc.nextLine();
				tr.delete(tr.root,s);
			}
			else if(n==3) {
				String s = sc.nextLine();
				System.out.println(tr.search(s));
			}
			else if(n==4) {
				String s="";
				tr.display(tr.root,s);
			}
		}
		sc.close();
	}
}