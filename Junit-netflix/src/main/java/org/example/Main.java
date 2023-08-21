package org.example;

import entidade.Profile;
import service.ProfileManagerService;

public class Main {


    public static void main(String[] args) {
        ProfileManagerService profileManager=new ProfileManagerService();

        Profile JulienProfile= new Profile("Julien",22);
        if (profileManager.addProfile(JulienProfile)) {
            System.out.println("Perfil adicionado com sucesso.");
        } else {
            System.out.println("Perfil com o mesmo nome ja existe.");
        }

        Profile retrievedProfile = profileManager.getProfileByName("Maria");
        if (retrievedProfile != null) {
            System.out.println("Perfil Recuperado: " + retrievedProfile.getName() + ", Idade: " + retrievedProfile.getAge());
        } else {
            System.out.println("Perfil não encontrado.");
        }

        boolean ageUpdateSuccess = profileManager.updateProfileAge("Maria", 26);
        if (ageUpdateSuccess) {
            System.out.println("Idade atualizada com sucesso.");
        } else {
            System.out.println("Perfil não encontrado ou idade não atualizada");
        }
    }

}