package org.harden.coder.simple;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/4 17:36
 * 文件说明：
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）
 * 。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）
 * 。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。
 * 要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，
 * 则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 *
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，
 * 返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 * 输入： solution="RGBY",guess="GGRR"
 * 输出： [1,1]
 * 解释： 猜中1次，伪猜中1次。
 * </p>
 */
public class MasterMind {
//    要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，
//    则算一次“伪猜中”。

    public int[] masterMind(String solution, String guess) {
        // RGBY RRRR
        // GGRR RRRG
        int len=solution.length();
        //排除选中
        boolean[] hit=new boolean[len];
        //过滤用过的
        boolean[] use=new boolean[len];
        int hitCount=0;
        int fakeCount=0;
        for(int i=0;i<len;i++){
            if(solution.charAt(i)==guess.charAt(i)){
                hit[i]=true;
                use[i]=true;
                hitCount++;
            }
        }
        for(int i=0;i<len;i++){
            //用过直接跳过
            if(hit[i]){
                continue;
            }
            for(int j=0;j<len;j++){
                if(solution.charAt(i)==guess.charAt(j) && !use[j]){
                    use[j]=true;
                    fakeCount++;
                    break;
                }
            }
        }

        return new int[]{hitCount,fakeCount};
    }
}
