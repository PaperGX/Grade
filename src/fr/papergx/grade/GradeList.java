package fr.papergx.grade;

public enum GradeList {
    FONDATEUR(14,"§4§lFondateur§4"),
    ADMINISTRATEUR(13, "§c§lAdministrateur§c"),
    COMMUNITYMANAGER(12, "§6§lCommunity-Manager§6"),
    RESPONSABLE(11, "§9§lResponsable§9"),
    MODERATEURPLUS(10, "§2§lModérateur+§2"),
    MODERATEUR(9, "§a§lModérateur§a"),
    HELPER(8, "§b§lHelper§b"),

    PARTENAIRE(7, "§d§lPartenaire§d"),
    YOUTUBEURPLUS(6, "§f§lYou§c§lTubeur+§c"),
    YOUTUBEUR(5, "§f§lYou§c§lTubeur§f"),
    ROI(4, "§e§lRoi§e"),
    PRINCE(3, "§5§lPrince§5"),
    NOBLE(2, "§3§lNoble§3"),
    CHEVALIER(1, "§8§lChevalier§8"),
    RECRUE(0, "§7§lRecrue§7");

    private final int power;
    private final String prefix;

    private GradeList(int power, String prefix) {
        this.power = power;
        this.prefix = prefix;
    }

    public final int getPower() {
        return power;
    }
    public final String getPrefix(){
        return prefix;
    }
    public final String getName(){
        return this.toString();
    }

}
