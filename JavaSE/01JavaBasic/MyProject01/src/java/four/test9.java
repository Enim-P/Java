package four;

import java.util.*;

public class test9 {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // 输入两个名字
        System.out.print("请输入第一个人的名字：");
        String name1 = scanner.nextLine();
        System.out.print("请输入第二个人的名字：");
        String name2 = scanner.nextLine();

        // 输入爱心大小
        System.out.print("请输入爱心大小（建议5~25之间）：");
        int size = scanner.nextInt();
        size = Math.max(2, Math.min(size, 50)); // 限制范围

        List<String> heartLines = generateHeart(size);

        // 打印居中的名字行
        String nameLine = name1 + "   ❤   " + name2;
        int maxWidth = heartLines.get(0).length();
        int padding = (maxWidth - nameLine.length()) / 2;
        System.out.println(repeatSpace(padding) + nameLine);
        Thread.sleep(400);

        // 打印爱心动画
        for (String line : heartLines) {
            System.out.println(line);
            Thread.sleep(100);
        }
    }

    // 生成可调大小的字符爱心图案
    public static List<String> generateHeart(int size) {
        List<String> lines = new ArrayList<>();
        double yScale = 1.5;

        for (double y = size * 0.3; y > -size * 0.3; y -= 0.1) {
            StringBuilder line = new StringBuilder();
            for (double x = -size * 0.3; x < size * 0.3; x += 0.05) {
                double a = x * x + (y / yScale) * (y / yScale) - 1;
                if ((a * a * a - x * x * (y / yScale) * (y / yScale) * (y / yScale)) <= 0) {
                    line.append("*");
                } else {
                    line.append(" ");
                }
            }
            lines.add(line.toString());
        }

        return lines;
    }

    // 辅助方法：生成 n 个空格
    public static String repeatSpace(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(0, count); i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}

