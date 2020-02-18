package treeekpresi;

class KonstantaInfix {

    char operator[] = {'+', '-', '*', '/', '^'};
    char operand[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char data;

    public KonstantaInfix() {
        data = ' ';
    }

    public void setData(char data_in) {
        data = data_in;
    }

    public boolean isOperator() {
        for (int i = 0; i < operator.length; i++) {
            if (data == operator[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean isOperand() {
        for (int i = 0; i < operand.length; i++) {
            if (data == operand[i]) {
                return true;
            }
        }
        return false;
    }
}

public class Infix {

    char ung[];//array bertipe char untuk menampung tiap karakter yang diinput.
    KonstantaInfix karInfix = new KonstantaInfix();//variable dengan tipe KonstantaInfix
    StackTree opr;//StackTree yang digunakan untuk menampung Operator
    StackTree opd;//StackTree yang digunakan untuk menampung Operand

    public Infix(char ung_in[]) {
        ung = ung_in; /*method yang digunakan untuk mengeset String/Karakter
        dari main ke dalam ung[]
        */
    }

    public int valensi(char data_in) {/*
        Method yang digunakan untuk memberi nilai tiap karakter. Namun dalam 
        notasi infix dengan 2 pembagian perhitungan belum digunakan.
        */
        if (data_in == '^') {
            return 3;
        } else if ((data_in == '*') || (data_in == '/')) {
            return 2;
        } else if ((data_in == '+') || (data_in == '-')) {
            return 1;
        } else if (data_in == '(') {
            return 0;
        } else {
            return -1;
        }
    }

    public TreeNode gabung() {/*
        Method yang digunakan untuk menggabungkan operasi aljabar dengan cara
        mengambil 1 node dari Opr dan menambahkan anak dari Opd.
        */
        TreeNode phn = opr.pop();
        phn.setRightChild(opd.pop());
        phn.setLeftChild(opd.pop());
        return phn;
    }

    public TreeNode buatPohon() {/*
        Method ini berfungsi untuk membuat tree dengan algoritma dari notasi 
        infix. Program ini bekerja dengan  mengembalikan TreeNode yang sudah 
        mempunyai anak sebagai sebuah tree. Program ini hanya dapat mengoperasi
        kan program aljabar saja seperti ( A * B ) ^ C
        */
        char kar;
        TreeNode cek = null;
        opr = new StackTree();
        opd = new StackTree();

        for (int i = 0; i < ung.length; i++) {
            kar = ung[i];
            cek = new TreeNode(kar);

            if (kar != ')') {
                if (kar == '(') {
                    opr.push(cek);
                } else {
                    karInfix.setData(kar);
                    if (karInfix.isOperand()) {
                        opd.push(cek);
                    } else if (karInfix.isOperator()) {
                        opr.push(cek);
                    }
                }
            } else if (kar == ')') {
                cek = gabung();
                opr.pop();
                opd.push(cek);
            }
        }
        while (!opr.isEmpty()) {
            cek = gabung();
            opd.push(cek);
        }
        return cek = opd.pop();
    }
}
