<template>
  <div class="bar">
    <p>bar</p>
    <div>
      <h3>one</h3>
      <slot name="one">one</slot>
    </div>
    <div>
      <h3>default</h3>
      <slot>default</slot>
    </div>
    <br>
  </div>
</template>

<script>
export default {
  name: "MyBar"
}
</script>

<style scoped>
.bar {
  width: 100px;
  min-height: 50px;
  background-color: yellow;
  margin: 0 auto;
}
</style>
