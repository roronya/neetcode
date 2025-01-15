package suburi;

import java.util.*;
import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[10]; // 配列の初期化
        array[0] = 100;
        System.out.println(array);
        System.out.println(Arrays.toString(array)); // 配列のプリント 初期化時点で0リセットされる仕様

        int[] array2 = {1, 2, 3, 4, 5}; // 値を指定した初期化 リテラルで初期化できる
        int[] array3 = new int[]{1, 2, 3, 4, 5}; // リテラルを使わずに初期化もできる

        // 配列は要素数を変更できない。やりたい場合はArrays.copyOfを使う
        int[] src = {1, 2, 3, 4, 5};
        int[] copy1 = Arrays.copyOf(src, 3);
        int[] copy2 = Arrays.copyOf(src, 10);
        System.out.println(Arrays.toString(copy1));
        System.out.println(Arrays.toString(copy2));
        // Pythonのスライスみたいなのはないが、util関数がある src[2:4]
        int[] slices = Arrays.copyOfRange(src, 2, 4);
        System.out.println(Arrays.toString(slices)); // [3,4]

        // sort
        array = new int[]{3, 4, 5, 1, 2, 6, 7, 8, 9, 0};
        Arrays.sort(array); // 破壊的メソッドなので注意
        System.out.println(Arrays.toString(array));
        // デフォルトは昇順
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        // 独自の比較関数で降順にする例
        // 戻り値が0以上の場合: 第一引数→第二引数の順
        // 戻り値が未満の場合: 第二引数→第一引数の順
        Integer[] a = new Integer[]{3, 4, 5, 1, 2, 6, 7, 8, 9, 0};
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        Arrays.sort(a, c);
        System.out.println(Arrays.toString(a));

        // note: Comparable Interfaceはそのクラスの自然なソートを定義するときに使う
        // Comperatorは独自ソート順のロジック定義に使う

        // search
        Arrays.sort(a); // binarySearchはソート済みであることが前提
        System.out.println(Arrays.binarySearch(a, 5)); // 5を返す 5のindex
        System.out.println(Arrays.binarySearch(a, 100)); // 見つからなかった場合は負の値を返す

        // ArrayList
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);

        // 関数インターフェース
        /// 2引数の関数はBinaryOperatorを使う
        Map<String, BinaryOperator<Integer>> operatorMap = new HashMap<>();
        operatorMap.put("+", (s, t) -> s + t);
        operatorMap.put("-", (s, t) -> s - t);
        operatorMap.put("*", (s, t) -> s * t);
        operatorMap.put("/", (s, t) -> s / t);
        BinaryOperator<Integer> f = operatorMap.get("+");
        System.out.println(f.apply(1, 10)); // => 11

        // 自分で@FunctionalInterfaceを作ることもできる
        Operator myFunction = (s, t) -> s + t + s;
        System.out.println(myFunction.apply(1, 2)); // => 4

        // String → Integerの変換
        Integer.parseInt("1"); // => intの1
        Integer.valueOf("1"); // => Integerの1

        // Integer -> Stringの変換
        String.valueOf(1); // => "1"

        // 文字列のリバース
        String original = "hello";
        String reversed = new StringBuilder(original).reverse().toString();
        System.out.println(reversed); // 出力: "olleh"

        // 同一性 forループ回すしか無い
        int[] a1 = new int[2];
        int[] a2 = new int[2];
        System.out.println(a1 == a2); // false
        a1[0] = 100;
        System.out.println(a1 == a2); // false
    }

    @FunctionalInterface
    interface Operator {
        int apply(int a, int b);
    }

}
