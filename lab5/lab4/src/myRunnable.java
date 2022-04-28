public class myRunnable  implements Runnable{
    double bottomBorder;
    double topBorder;
    double step;
    double result = 0.0;
   
    myRunnable(double _bottomBorder, double _topBorder, double _step)  {
        bottomBorder = _bottomBorder;
        topBorder = _topBorder;
        step = _step;
      
    }

    @Override
    public void run() {
        System.out.println("Поток запущен");
       for(double i  = bottomBorder; i < topBorder; i += step)
           result += step * (Math.pow(i, 0.5) + Math.pow(i + step, 0.5)) / 2;
           
        }
    
        
    public synchronized double getResult() {
        return result;
    }
}
