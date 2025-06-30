<template>
  <div class="container mx-auto py-8">
    <NuxtLink to="/" class="text-blue-500 hover:underline">← 목록으로</NuxtLink>
    <div v-if="loading" class="mt-8 text-gray-500">로딩 중...</div>
    <div v-else-if="post" class="mt-8">
      <h1 class="text-2xl font-bold mb-2">{{ post.title }}</h1>
      <p class="text-gray-500 text-sm mb-4">{{ formatDate(post.createdAt) }}</p>
      <div class="prose max-w-none mb-8">{{ post.content }}</div>
      <NuxtLink
        :to="`/posts/edit/${post.id}`"
        class="px-4 py-2 bg-yellow-400 text-white rounded hover:bg-yellow-500"
        >수정</NuxtLink
      >
    </div>
    <div v-else class="mt-8 text-red-500">게시글을 찾을 수 없습니다.</div>
  </div>
</template>

<script setup lang="ts">
interface Post {
  id: number;
  title: string;
  content: string;
  createdAt: string;
}
const route = useRoute();

const { data: post, pending: loading } = await useAsyncData("post", () =>
  $fetch<Post>(`http://localhost:8080/api/posts/${route.params.id}`)
);

function formatDate(date: string) {
  return new Date(date).toLocaleString("ko-KR");
}
</script>
