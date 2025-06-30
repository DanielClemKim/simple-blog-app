<template>
  <NuxtLink :to="`/posts/${post.id}`" class="block py-4 hover:bg-gray-50">
    <h2 class="text-xl font-semibold">{{ post.title }}</h2>
    <p class="text-gray-500 text-sm mt-1">{{ formatDate(post.createdAt) }}</p>
  </NuxtLink>
</template>

<script setup lang="ts">
defineProps<{
  post: { id: number; title: string; content: string; createdAt: string };
}>();

function formatDate(date: string) {
  return new Date(date).toLocaleString("ko-KR");
}
</script>
