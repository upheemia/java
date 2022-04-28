
public class myRunnable  implements Runnable{
    double bottomBorder;
    double topBorder;
    double step;
    double result = 0.0;
   
    myRunnable(String _bottomBorder, String _topBorder, String _step)  {
        bottomBorder = Double.parseDouble(_bottomBorder);
        topBorder = Double.parseDouble(_topBorder);
        step = Double.parseDouble(_step);
        
  
    }

    @Override
    public void run() {
      
       for(double i  = bottomBorder; i < topBorder; i += step)
           result += step * (Math.pow(i, 0.5) + Math.pow(i + step, 0.5)) / 2;
           
        }
        
    public synchronized double getResult() {
        return result;
    }

}

    

