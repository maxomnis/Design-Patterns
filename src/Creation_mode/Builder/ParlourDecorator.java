package Builder;

import java.awt.*;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * 用建造者（Builder）模式描述客厅装修。
 *
 * 分析：客厅装修是一个复杂的过程，它包含墙体的装修、电视机的选择、沙发的购买与布局等。客户把装修要求告诉项目经理，
 * 项目经理指挥装修工人一步步装修，最后完成整个客厅的装修与布局，所以本实例用建造者模式实现比较适合。
 *
 * 这里客厅是产品，包括墙、电视和沙发等组成部分。具体装修工人是具体建造者，他们负责装修与墙、电视和沙发的布局。项目经理是指挥者，他负责指挥装修工人进行装修。
 *
 * 另外，客厅类中提供了 show() 方法，可以将装修效果图显示出来（点此下载装修效果图的图片）。客户端程序通过对象生成器类 ReadXML 读取 XML
 * 配置文件中的装修方案数据（点此下载 XML 文件），调用项目经理进行装修。其类图如图 2 所示。
 */
public class ParlourDecorator {
    public static void main(String[] args) {
        try {
            Decorator d;
            d = (Decorator) ReadXML.getObject();
            ProjectManager m = new ProjectManager(d);
            Parlour p = m.decorate();
            p.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//产品：客厅
class Parlour {
    private String wall;    //墙
    private String TV;    //电视
    private String sofa;    //沙发

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setTV(String TV) {
        this.TV = TV;
    }

    public void setSofa(String sofa) {
        this.sofa = sofa;
    }

    public void show() {
        JFrame jf = new JFrame("建造者模式测试");
        Container contentPane = jf.getContentPane();
        JPanel p = new JPanel();
        JScrollPane sp = new JScrollPane(p);
        String parlour = wall + TV + sofa;
        JLabel l = new JLabel(new ImageIcon("src/" + parlour + ".jpg"));
        p.setLayout(new GridLayout(1, 1));
        p.setBorder(BorderFactory.createTitledBorder("客厅"));
        p.add(l);
        contentPane.add(sp, BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

//抽象建造者：装修工人
abstract class Decorator {
    //创建产品对象
    protected Parlour product = new Parlour();

    public abstract void buildWall();

    public abstract void buildTV();

    public abstract void buildSofa();

    //返回产品对象
    public Parlour getResult() {
        return product;
    }
}

//具体建造者：具体装修工人1
class ConcreteDecorator1 extends Decorator {
    @Override
    public void buildWall() {
        product.setWall("w1");
    }

    @Override
    public void buildTV() {
        product.setTV("TV1");
    }

    @Override
    public void buildSofa() {
        product.setSofa("sf1");
    }
}

//具体建造者：具体装修工人2
class ConcreteDecorator2 extends Decorator {
    @Override
    public void buildWall() {
        product.setWall("w2");
    }

    @Override
    public void buildTV() {
        product.setTV("TV2");
    }

    @Override
    public void buildSofa() {
        product.setSofa("sf2");
    }
}

//指挥者：项目经理
class ProjectManager {
    private Decorator builder;

    public ProjectManager(Decorator builder) {
        this.builder = builder;
    }

    //产品构建与组装方法
    public Parlour decorate() {
        builder.buildWall();
        builder.buildTV();
        builder.buildSofa();
        return builder.getResult();
    }
}

