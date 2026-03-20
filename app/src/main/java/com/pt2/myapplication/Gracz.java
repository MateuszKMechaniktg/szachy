package com.pt2.myapplication;

import android.os.CountDownTimer;
import android.widget.Button;

public class Gracz {
    private int ileSekund;
    private CountDownTimer countDownTimer;
    private Button button;
    private boolean czyAktywny;

    public Gracz(Button button, boolean czyAktywny) {
        this.button = button;
        this.czyAktywny = czyAktywny;
        ileSekund = 180;
        if (czyAktywny){
            uruchomZegar();
        }
    }
    private void zatrzymajZegar(){
        countDownTimer.cancel();
    }
    public void zmienAktywnosc(){
        czyAktywny = !czyAktywny;
        if(czyAktywny){
            uruchomZegar();
        }else{
            zatrzymajZegar();
        }
    }
    private void uruchomZegar(){
        countDownTimer = new CountDownTimer(ileSekund * 1000, 1000) {
            @Override
            public void onTick(long l) {
                ileSekund = (int) (l/1000);
                button.setText(ileSekund+"");
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }
}
