package maze.solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

    private final int [][] maze =
            {
                    {1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,1,0,0,1},
                    {1,0,1,0,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,0,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,0,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1,9,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
            };

    private final List<Integer> path = new ArrayList<>();

    public Main() {
        setTitle("Maze Solver");
        setSize(640,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirstSearch.searchPath(maze,1,1,path);
        System.out.println(path);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.translate(50, 50);

        for (int row=0;row<maze.length;row++)
        {
            for (int col=0;col<maze[0].length;col++)
            {
                Color color = switch (maze[row][col]) {
                    case 1 -> Color.BLACK;
                    case 9 -> Color.RED;
                    default -> Color.WHITE;
                };
                g.setColor(color);
                g.fillRect(30*col,30*row,30,30);
                g.setColor(Color.RED);
                g.drawRect(30*col,30*row,30,30);

            }
        }

        for(int p=0;p<path.size();p+=2)
        {
            int pathx=path.get(p);
            int pathy=path.get(p+1);
            System.out.println("path x coordinate"+pathx);
            System.out.println("path y coordinate"+pathy);
            g.setColor(Color.GREEN);
            g.fillRect(pathx*30, pathy*30, 30, 30);

        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main view = new Main();
            view.setVisible(true);
        });
    }
}
