/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    './index.html',
    './src/**/*.{js,ts,jsx,tsx,css,md,mdx,html,json,scss}',
  ],
  darkMode: 'class',
    theme: {
      extend: {
          keyframes: {
              wiggle: {
                '0%, 100%': {
                    transform: 'rotate(-3deg)'
                },
                '50%': {
                    transform: 'rotate(3deg)'
                },
              },
              size: {
                '0%, 100%': {
                  transform: 'scale(2)'
                },
                '50%': {
                  transform: 'scale(1)'
                }
              },
              asd: {
                '0%, 100%': {
                  transform: 'scale(4) rotate(-4deg)',
                },
                '50%': {
                  transform: 'scale(0.1) rotate(4deg)'
                }
              },
          },
          animation: {
              wiggle: 'wiggle 1s ease-in-out infinite',
              size: 'size 1s ease-in-out infinite',
              asd: 'asd 1s ease-in-out infinite',
          }
      },
  },
  plugins: [],
};
