import type { Component } from 'solid-js'

const TheStrang: string = " grid grid-cols-1 items-center justify-items-center w-32 h-32 m-2 "

interface TastyProps {
    class: string
}

function Tasty(props: TastyProps) {
  return (
    <div class={TheStrang + "rounded-full " + props.class}>
      <div class="text-white font-extrabold text-3xl">
        Circle
      </div>
    </div>
  );
}

function Tasty2(props: TastyProps) {
  return (
    <div class={TheStrang + " rounded-sm " + props.class}>
      <div class="text-white font-extrabold text-3xl">
        Square
      </div>
    </div>
  );
}

function Circler() {
    return (
      <div class="flex items-center justify-center animate-wiggle flex-nowrap overflow-hidden">
        <Tasty2 class="bg-[#395E66]"/>
        <Tasty class="bg-[#387D7A]"/>
        <Tasty2 class="bg-[#32936F]"/>
        <Tasty class="bg-[#26A96C]"/>
      </div>
    );
  }

const App: Component = () => {
  return (
    <>
      <div class="m-60"/>
      <Circler/>
    </>
  );
}

export default App;
