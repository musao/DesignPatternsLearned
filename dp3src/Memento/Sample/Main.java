import game.Memento;
import game.Gamer;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);               // �ŏ��̏�������100
        Memento memento = gamer.createMemento();    // �ŏ��̏�Ԃ�ۑ����Ă���

        // �Q�[���X�^�[�g
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);        // �񐔕\��
            System.out.println("����:" + gamer);    // ���݂̎�l���̏�ԕ\��

            // �Q�[����i�߂�
            gamer.bet();

            System.out.println("��������" + gamer.getMoney() + "�~�ɂȂ�܂����B");

            // Memento�̎�舵���̌���
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("�������ԑ������̂ŁA���݂̏�Ԃ�ۑ����Ă������I");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("�������Ԍ������̂ŁA�ȑO�̏�Ԃ𕜌����悤�I");
                gamer.restoreMemento(memento);
            }

            // ���ԑ҂�
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println();
        }
    }
}