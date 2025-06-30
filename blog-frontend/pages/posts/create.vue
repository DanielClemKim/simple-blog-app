<template>
  <div class="container mx-auto py-8">
    <NuxtLink to="/" class="text-blue-500 hover:underline">← 목록으로</NuxtLink>
    <h1 class="text-2xl font-bold mb-6 mt-4">글 작성</h1>
    <PostForm :editMode="false" />
  </div>
</template>

<script setup lang="ts"></script>
