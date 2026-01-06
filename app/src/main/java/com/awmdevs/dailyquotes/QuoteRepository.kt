package com.example.dailyquotes

enum class Category(val labelFr: String, val labelEn: String) {
    ANIME("Anime", "Anime"),
    SPORT("Sport", "Sport"),
    MOTIVATION("Motivation", "Motivation"),
    DISCIPLINE("Discipline", "Discipline"),
    CONFIANCE("Confiance", "Confidence"),
    ZEN("Zen", "Zen"),
    DROLE("Drôle", "Funny")
}

data class Quote(
    val id: Int,
    val textFr: String,
    val textEn: String,
    val author: String,
    val category: Category
)

object QuoteRepository {

    fun allQuotes(): List<Quote> = listOf(
        // --- ANIME (1-14) ---
        Quote(1, "Même un héros commence petit.", "Even a hero starts small.", "Anonyme", Category.ANIME),
        Quote(2, "Ton entraînement d’aujourd’hui devient ta force demain.", "Today’s training becomes tomorrow’s strength.", "Anonyme", Category.ANIME),
        Quote(3, "Tombe, relève-toi, évolue.", "Fall, get up, evolve.", "Anonyme", Category.ANIME),
        Quote(4, "Un pas de plus, encore.", "One more step, again.", "Anonyme", Category.ANIME),
        Quote(5, "Le courage, c’est continuer malgré la peur.", "Courage is continuing despite fear.", "Anonyme", Category.ANIME),
        Quote(6, "Ta détermination écrit ton histoire.", "Your determination writes your story.", "Anonyme", Category.ANIME),
        Quote(7, "Ce n’est pas la fin tant que tu respires.", "It’s not over while you still breathe.", "Anonyme", Category.ANIME),
        Quote(8, "Garde ton objectif en vue.", "Keep your goal in sight.", "Anonyme", Category.ANIME),
        Quote(9, "Ta constance fait la différence.", "Your consistency makes the difference.", "Anonyme", Category.ANIME),
        Quote(10, "Le mental gagne les derniers mètres.", "Mindset wins the last meters.", "Anonyme", Category.ANIME),
        Quote(11, "Tu peux devenir meilleur chaque jour.", "You can get better every day.", "Anonyme", Category.ANIME),
        Quote(12, "Le vrai pouvoir : ne pas abandonner.", "Real power: not giving up.", "Anonyme", Category.ANIME),
        Quote(13, "Ta patience est une arme.", "Patience is a weapon.", "Anonyme", Category.ANIME),
        Quote(14, "Ton effort parle pour toi.", "Your effort speaks for you.", "Anonyme", Category.ANIME),

        // --- SPORT (15-28) ---
        Quote(15, "La régularité bat la séance parfaite.", "Consistency beats the perfect session.", "Anonyme", Category.SPORT),
        Quote(16, "Chaque répétition compte.", "Every rep counts.", "Anonyme", Category.SPORT),
        Quote(17, "Tu ne regrettes jamais une séance terminée.", "You never regret a finished workout.", "Anonyme", Category.SPORT),
        Quote(18, "La discipline est ton coach silencieux.", "Discipline is your silent coach.", "Anonyme", Category.SPORT),
        Quote(19, "Respire, concentre-toi, exécute.", "Breathe, focus, execute.", "Anonyme", Category.SPORT),
        Quote(20, "Ton corps suit ton esprit.", "Your body follows your mind.", "Anonyme", Category.SPORT),
        Quote(21, "Les petits efforts s’additionnent.", "Small efforts add up.", "Anonyme", Category.SPORT),
        Quote(22, "Le progrès aime la patience.", "Progress loves patience.", "Anonyme", Category.SPORT),
        Quote(23, "La fatigue passe, la fierté reste.", "Fatigue fades, pride stays.", "Anonyme", Category.SPORT),
        Quote(24, "Gagne la bataille contre l’excuse.", "Win the battle against excuses.", "Anonyme", Category.SPORT),
        Quote(25, "Aujourd’hui : effort. Demain : résultat.", "Today: effort. Tomorrow: result.", "Anonyme", Category.SPORT),
        Quote(26, "Continue, même lentement.", "Keep going, even slowly.", "Anonyme", Category.SPORT),
        Quote(27, "Ta forme se construit.", "Fitness is built.", "Anonyme", Category.SPORT),
        Quote(28, "Un jour off n’efface pas ton progrès.", "One day off doesn’t erase your progress.", "Anonyme", Category.SPORT),

        // --- MOTIVATION (29-42) ---
        Quote(29, "Commence maintenant.", "Start now.", "Anonyme", Category.MOTIVATION),
        Quote(30, "Un jour ou jour un. À toi de choisir.", "One day or day one. You choose.", "Anonyme", Category.MOTIVATION),
        Quote(31, "L’action crée la clarté.", "Action creates clarity.", "Anonyme", Category.MOTIVATION),
        Quote(32, "Tu n’as pas besoin d’aller vite. Tu dois avancer.", "You don’t need to be fast. You need to move.", "Anonyme", Category.MOTIVATION),
        Quote(33, "Ne lâche pas pour une mauvaise journée.", "Don’t quit because of a bad day.", "Anonyme", Category.MOTIVATION),
        Quote(34, "Tu peux recommencer aujourd’hui.", "You can restart today.", "Anonyme", Category.MOTIVATION),
        Quote(35, "Ton futur dépend de tes habitudes.", "Your future depends on your habits.", "Anonyme", Category.MOTIVATION),
        Quote(36, "Le meilleur moment, c’est maintenant.", "The best time is now.", "Anonyme", Category.MOTIVATION),
        Quote(37, "Fais-le, même sans envie.", "Do it even without motivation.", "Anonyme", Category.MOTIVATION),
        Quote(38, "Un pas suffit pour commencer.", "One step is enough to begin.", "Anonyme", Category.MOTIVATION),
        Quote(39, "Continue. Tu es plus proche que tu ne crois.", "Keep going. You’re closer than you think.", "Anonyme", Category.MOTIVATION),
        Quote(40, "Ta décision d’aujourd’hui compte.", "Today’s decision matters.", "Anonyme", Category.MOTIVATION),
        Quote(41, "Fais le prochain pas, pas toute la route.", "Take the next step, not the whole road.", "Anonyme", Category.MOTIVATION),
        Quote(42, "Fais-le pour toi.", "Do it for yourself.", "Anonyme", Category.MOTIVATION),

        // --- DISCIPLINE (43-56) ---
        Quote(43, "La discipline bat la motivation.", "Discipline beats motivation.", "Anonyme", Category.DISCIPLINE),
        Quote(44, "Sois constant, pas parfait.", "Be consistent, not perfect.", "Anonyme", Category.DISCIPLINE),
        Quote(45, "La répétition crée la maîtrise.", "Repetition creates mastery.", "Anonyme", Category.DISCIPLINE),
        Quote(46, "La constance vaut plus que l’intensité.", "Consistency matters more than intensity.", "Anonyme", Category.DISCIPLINE),
        Quote(47, "Fais simple, fais bien.", "Keep it simple, do it well.", "Anonyme", Category.DISCIPLINE),
        Quote(48, "Tes habitudes te construisent.", "Your habits build you.", "Anonyme", Category.DISCIPLINE),
        Quote(49, "Un petit effort chaque jour.", "A small effort every day.", "Anonyme", Category.DISCIPLINE),
        Quote(50, "Ce que tu répètes devient toi.", "What you repeat becomes you.", "Anonyme", Category.DISCIPLINE),
        Quote(51, "La patience est une stratégie.", "Patience is a strategy.", "Anonyme", Category.DISCIPLINE),
        Quote(52, "Fais moins, mais mieux.", "Do less, but better.", "Anonyme", Category.DISCIPLINE),
        Quote(53, "La discipline crée la liberté.", "Discipline creates freedom.", "Anonyme", Category.DISCIPLINE),
        Quote(54, "Ton focus est ta puissance.", "Your focus is your power.", "Anonyme", Category.DISCIPLINE),
        Quote(55, "Le travail silencieux donne des résultats bruyants.", "Quiet work creates loud results.", "Anonyme", Category.DISCIPLINE),
        Quote(56, "Recommencer n’est pas reculer.", "Starting again isn’t going backward.", "Anonyme", Category.DISCIPLINE),

        // --- CONFIANCE (57-70) ---
        Quote(57, "Tu es capable, même si c’est difficile.", "You are capable, even when it’s hard.", "Anonyme", Category.CONFIANCE),
        Quote(58, "La confiance se construit.", "Confidence is built.", "Anonyme", Category.CONFIANCE),
        Quote(59, "Ton rythme est valide.", "Your pace is valid.", "Anonyme", Category.CONFIANCE),
        Quote(60, "Tu n’échoues pas, tu apprends.", "You’re not failing, you’re learning.", "Anonyme", Category.CONFIANCE),
        Quote(61, "Tu peux être fier de ton effort.", "You can be proud of your effort.", "Anonyme", Category.CONFIANCE),
        Quote(62, "Tu es en construction, pas en retard.", "You’re in progress, not behind.", "Anonyme", Category.CONFIANCE),
        Quote(63, "Chaque petite victoire compte.", "Every small win matters.", "Anonyme", Category.CONFIANCE),
        Quote(64, "Tu peux gérer plus que tu ne crois.", "You can handle more than you think.", "Anonyme", Category.CONFIANCE),
        Quote(65, "Ton effort a de la valeur.", "Your effort has value.", "Anonyme", Category.CONFIANCE),
        Quote(66, "Change la méthode, pas l’objectif.", "Change the method, not the goal.", "Anonyme", Category.CONFIANCE),
        Quote(67, "Le courage, c’est d’essayer encore.", "Courage is trying again.", "Anonyme", Category.CONFIANCE),
        Quote(68, "Garde la tête froide, le cœur chaud.", "Keep a cool head, a warm heart.", "Anonyme", Category.CONFIANCE),
        Quote(69, "Tu apprends en avançant.", "You learn by moving forward.", "Anonyme", Category.CONFIANCE),
        Quote(70, "Ton progrès compte.", "Your progress matters.", "Anonyme", Category.CONFIANCE),

        // --- ZEN (71-85) ---
        Quote(71, "Respire. Tout passe.", "Breathe. Everything passes.", "Anonyme", Category.ZEN),
        Quote(72, "La paix commence en toi.", "Peace begins within you.", "Anonyme", Category.ZEN),
        Quote(73, "Choisis la simplicité.", "Choose simplicity.", "Anonyme", Category.ZEN),
        Quote(74, "La gratitude change la journée.", "Gratitude changes the day.", "Anonyme", Category.ZEN),
        Quote(75, "Ralentir, c’est aussi avancer.", "Slowing down is also moving forward.", "Anonyme", Category.ZEN),
        Quote(76, "Le calme est une force.", "Calm is strength.", "Anonyme", Category.ZEN),
        Quote(77, "L’énergie suit l’attention.", "Energy follows attention.", "Anonyme", Category.ZEN),
        Quote(78, "Tes limites protègent ta paix.", "Your boundaries protect your peace.", "Anonyme", Category.ZEN),
        Quote(79, "Moins de bruit, plus de vie.", "Less noise, more life.", "Anonyme", Category.ZEN),
        Quote(80, "Fais de la place pour la paix.", "Make room for peace.", "Anonyme", Category.ZEN),
        Quote(81, "Un esprit clair, une vie plus légère.", "A clear mind, a lighter life.", "Anonyme", Category.ZEN),
        Quote(82, "Tu n’as pas besoin de tout contrôler.", "You don’t need to control everything.", "Anonyme", Category.ZEN),
        Quote(83, "Le calme n’est pas l’absence de problèmes.", "Calm isn’t the absence of problems.", "Anonyme", Category.ZEN),
        Quote(84, "Sois patient avec toi-même.", "Be patient with yourself.", "Anonyme", Category.ZEN),
        Quote(85, "La paix vaut plus que l’ego.", "Peace is worth more than ego.", "Anonyme", Category.ZEN),

        // --- DRÔLE (86-100) ---
        Quote(86, "Je voulais être productif… puis j’ai ouvert YouTube.", "I wanted to be productive… then I opened YouTube.", "Anonyme", Category.DROLE),
        Quote(87, "Mon plan : être sérieux. Mon cerveau : lol non.", "My plan: be serious. My brain: lol nope.", "Anonyme", Category.DROLE),
        Quote(88, "Je commence demain. Demain est très occupé.", "I’ll start tomorrow. Tomorrow is very busy.", "Anonyme", Category.DROLE),
        Quote(89, "J’ai besoin de motivation. Où est le bouton ?", "I need motivation. Where’s the button?", "Anonyme", Category.DROLE),
        Quote(90, "Je ne suis pas en retard, je suis en mode économie d’énergie.", "I’m not late, I’m in power-saving mode.", "Anonyme", Category.DROLE),
        Quote(91, "Si dormir était un sport, j’aurais une médaille.", "If sleeping was a sport, I’d have a medal.", "Anonyme", Category.DROLE),
        Quote(92, "Je suis calme… tant que personne ne me parle.", "I’m calm… as long as nobody talks to me.", "Anonyme", Category.DROLE),
        Quote(93, "Je fais du multitâche : je stresse sur plusieurs sujets.", "I multitask: I stress about multiple things.", "Anonyme", Category.DROLE),
        Quote(94, "Je suis en forme : ronde est une forme.", "I’m in shape: round is a shape.", "Anonyme", Category.DROLE),
        Quote(95, "Je suis organisé : tout est quelque part.", "I’m organized: everything is somewhere.", "Anonyme", Category.DROLE),
        Quote(96, "Mon téléphone sait tout. Moi, je sais où est mon chargeur ? Non.", "My phone knows everything. Do I know where my charger is? No.", "Anonyme", Category.DROLE),
        Quote(97, "J’ai fait une liste. J’ai perdu la liste.", "I made a list. I lost the list.", "Anonyme", Category.DROLE),
        Quote(98, "La motivation est partie… je laisse un message après le bip.", "Motivation is gone… leave a message after the beep.", "Anonyme", Category.DROLE),
        Quote(99, "J’ai couru… dans mes rêves.", "I ran… in my dreams.", "Anonyme", Category.DROLE),
        Quote(100, "Je vais être adulte demain. Aujourd’hui, pas disponible.", "I’ll be an adult tomorrow. Today, unavailable.", "Anonyme", Category.DROLE)
    )
}
