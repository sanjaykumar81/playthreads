package sj.subtree;

class Solutions {
    private int maxHeight = 0;

    /**
     * Node count of the biggest perfect binary tree for a given tree.
     * @param T a binary tree
     * @return count of nodes of the biggest perfect binary tree
     */
    public int nodeCountOfBiggestPBT(Tree T) {
        int height = findHeight(T);

        return (int) (Math.pow(2, height +1)-1);
    }

    public int findHeight(Tree T){
        int tHeight = 0;
        if (T.l == null || T.r == null){
            return tHeight;
        }
        int ltHeight = findHeight(T.l);
        int rtHeight = findHeight(T.r);
        if (ltHeight <= rtHeight){
            tHeight = ltHeight +1;
        }else{
            tHeight = rtHeight+1;
        }
        if (maxHeight < tHeight){
            maxHeight = tHeight;
        }
        return tHeight;
    }

}

