# Taking out MSB:
4 2 1 0
1 0 0 0 

MSB = 4

formula = Math.log(x) / Math.log(2);

formula for taking out length = Math.log(x) / Math.log(2) + 1;

Java does not directly compute log base 2. It uses: Math.log(x)
👉 This is natural log (ln) → base e ≈ 2.718

log isn’t a simple operation like + or /
👉 It’s implemented using well-researched mathematical algorithms
  