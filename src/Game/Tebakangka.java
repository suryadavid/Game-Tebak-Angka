package Game;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Tebakangka {
    public static void main(String[] args) {
        ArrayList <String> namauser = new ArrayList<>();
        ArrayList <Integer> skor = new ArrayList<>();
        Scanner input1 = new Scanner(System.in);
        Scanner input2= new Scanner(System.in);
        Random random1=new Random();
        String cariY;
        
        do{
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("                                    GAME TEBAK ANGKA                                           ");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Masukkan 'Nama' Anda atau tekan 'y' untuk keluar, kemudian tekan enter = ");
            cariY=input1.nextLine();
            namauser.add(cariY);
            System.out.println("-----------------------------------------------------------------------------------------------");
            
            int Nilai = 0;
            int CekGameOver=0;
            int aKumulasi[]= new int[6];
            int NilaiPasJalan=0;
         
            if(!("y").equals(cariY)){  
            
                String nextLevel;
                int PilihLevel=1; 
                System.out.println("\t\t\t\tSelamat Datang " + cariY                          );
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.println("-----------------------------------------------------------------------------------------------");
                do{
                    
                int Kout, Ang, Pang;
                    System.out.println("# Level " + PilihLevel + " #");
                    int StarNilaiO=PilihLevel-1;    
                    Pang=PilihLevel*25;
                    System.out.println("Silahkan Tebak Angka Antara 1 s/d " + Pang + ".");
                    System.out.println("Anda mempunyai kesempatan menebak 5 kali.");
                    int AngKaAcak=random1.nextInt(Pang);
                    
                       for(Kout=0;Kout<=5;Kout++){
                        if(Kout==5){
                            System.out.println("GAMEOVER! Anda Gagal");
                            CekGameOver++;
                        }
                        else{  
                            System.out.println("Tebakan Anda ?");
                            int AkuTeb=input2.nextInt();
                            int Kurang=4-Kout;
                            if(AkuTeb==AngKaAcak){
                                
                                if(Kout==0){
                                    NilaiPasJalan=PilihLevel*25; 
                                }
                                else if(Kout==1){
                                    NilaiPasJalan=PilihLevel*20;
                                }
                                else if(Kout==2){
                                    NilaiPasJalan=PilihLevel*15;
                                }
                                else if(Kout==3){
                                    NilaiPasJalan=PilihLevel*10;
                                }
                                else{
                                    NilaiPasJalan=0;
                                }
                                
                                int NeTebak=Kout+1;
                                System.out.println("Selamat Anda berhasil menebak angka dalam " + NeTebak + " kali tebakan. Skor Anda adalah " + NilaiPasJalan + ".");
                                break;
                                
                                }
                            else{
                                if(AkuTeb>AngKaAcak){
                                    System.out.println("Tebakan Anda terlalu Besar! Anda mempunyai kesempatan " + Kurang + " kali lagi." ); // Jika Tebakan lebih besar dari angka random
                                }
                                else{

                                    System.out.println("Tebakan Anda terlalu Kecil! Anda mempunyai kesempatan " + Kurang + " kali lagi." ); // Jika tebakan lebih kecil dari angka random
                                }
                            }
                        }
                    }
                       
                       if(CekGameOver>0){
                        break;
                    }
                    
                    if(PilihLevel==5){
                        break;
                    }
                    else{
                    aKumulasi[StarNilaiO]=NilaiPasJalan;  
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    System.out.println("Ketik 'next' dan tekan enter untuk lanjut ke level berikutnya atau ketik 'exit' untuk keluar : ");
                    nextLevel=input1.nextLine();
                    PilihLevel++;
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    }
                   
                }
                while(!"exit".equals(nextLevel));
                
                } 
            
            for(int rO=0; rO<5; rO++){
                Nilai=Nilai+aKumulasi[rO];  
            }
            skor.add(Nilai);
            if(!"y".equals(cariY)){
            
            System.out.println("---------------");
            System.out.println("SCORE SEMENTARA");
                    System.out.println("---------------");
                    int xSemen, ySemen;
                    int xJumSemen=namauser.size();
                  
                    for(xSemen=0;xSemen<xJumSemen;xSemen++){
                        System.out.println(namauser.get(xSemen) + " : " + skor.get(xSemen));
                    }
                    System.out.println("---------------");
            }
            
        }        while(!"y".equals(cariY));
        int jumPemain=namauser.size();
        System.out.println("SCORE AKHIR");
        System.out.println("===============================================================================================");
        int l;
        for(l=0;l<jumPemain-1;l++){
            System.out.println(namauser.get(l) + " : " + skor.get(l));
        }
        System.out.println("===============================================================================================");
    }
}