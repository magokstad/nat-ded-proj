import type { Component } from 'solid-js'
import MathSVG from './MathSVG';

function Huh() {
    return (
    <div>
      <MathSVG math="hi"/>
    </div>
    );
  }

function Asdf() {
    return ( 
      <div class="animate-asd m-[30%] flex justify-center">
        Hi there
      </div>
    );
}

const App: Component = () => {
  return (
      //<Asdf/>
      <Huh/>
  );
}

export default App;
