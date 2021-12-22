# modelare-soft

## De ce functional style

In general este bine sa pornim de la cea mai simpla implementare posibila si trecem la solutii mai complexe pe masura ce este nevoie de acestea.
<br/>
In cazul de fata, o functie (pura) este mai simpla decat o clasa.
<br/>
O functie este pura daca pentru un set de date de intrare intoarce mereu aceleasi date de iesire, iar functia nu schimba datele de iesire. (ex: sum(3, 7) va intoarce mereu 10)
<br/>
Spre deosebire de programarea orientata pe obiect, folosirea functiilor pure duce la separarea datelor si a operatiilor care sa fac pe acestea.
<br/>
O alta deosebire este ca in programarea functionala, toate datele sunt imutabile

## Avantaje

1. Pe parte de reutilizare - deoarece functiile sunt pure, deci nu prezinta efecte secundare, putem sa le integram usor in alte biblioteci avand garantia ca biblioteca nu va fi afectata de noile functionalitati
2. Pe parte de extindere - Extinderea codului devine o chestiune doar de importarea functiilor de care avem nevoie. Acesta este un mare avantaj spre deosebire de programarea orientata pe obiect, deoarece prin Tree Shaking putem elimina functiile nefolosite din pachetul final reducand semnificativ dimensiunea aplicatiei.
3. Pe parte de testare - Nu exista nimic mai simplu de testat decat o functie care primeste niste date de intrare si intoarce date de iesire.
