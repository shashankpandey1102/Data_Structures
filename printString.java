public class printString {
    public static void findNoOfStrings(String s1, String s2){
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                System.out.print(s1.charAt(i));
                System.out.print(s2.charAt(j));
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        findNoOfStrings("abc","qwe");
    }
}
