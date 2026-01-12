<template>
  <div class="home">
    <Header></Header>
    <Main></Main>
    <Footer></Footer>
  </div>
</template>

<script setup>
import Header from '@/components/Header.vue';
import Main from '@/components/Main.vue';
import Footer from '@/components/Footer.vue';
</script>

<style lang="scss" scoped>
.home{
  border: 1px solid #ddd;
  padding: 10px;
  width: 500px;
}
</style>

