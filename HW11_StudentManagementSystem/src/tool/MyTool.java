package tool;

/**
 * Tool to solve some problmes when displaying
 * @author Renyu Liu
 *
 */
public class MyTool {
	/**
	 * Change the format of the string
	 * @param sourceDate of a studentmap
	 * @param formatLength of a studentmap
	 * @return newString
	 */
    public static String frontCompWithZore(int sourceDate,int formatLength) {
        String newString = String.format("%0"+formatLength+"d", sourceDate);

        return newString;
    }
    
    /**
     * Check for the time conflict
     * @param start1 the start time for 1
     * @param start2 the start time for 2
     * @param end1 the end time for 1
     * @param end2 the end time for 2
     * @return true if there is a time conflict
     */
    public static boolean isCoincidence(String start1,String start2,String end1,String end2) {
        return (timeToInt(start1)>=timeToInt(start2)&&timeToInt(start1)<timeToInt(end2))||
                (timeToInt(start2)>=timeToInt(start1)&&timeToInt(start2)<timeToInt(end1));
    }
    
    /**
     * Change time to ints
     * @param s the string used for isCoincidence()
     * @return 0 if cannot change the format 
     */
    public static int timeToInt(String s) {
        String data[]=s.split(":");
        if(data.length==2)
        {
        	// change the format 
            return Integer.parseInt(data[0])*100+Integer.parseInt(data[1]);
        }
        else {
            System.out.println("The change of format is not valid");
            return 0;
        }
    }

    /**
     * Some tests trying to see if it is working 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(MyTool.timeToInt("10:30"));
        System.out.println(MyTool.isCoincidence("10:30","10:00","11:00","11:30"));
        System.out.println(MyTool.isCoincidence("8:00","10:00","9:00","11:30"));
        System.out.println(MyTool.frontCompWithZore(1,3));
    }




}
