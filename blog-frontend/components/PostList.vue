<template>
  <div>
    <div v-if="loading" class="text-gray-500">로딩 중...</div>
    <div v-else>
      <div v-if="posts.length === 0" class="text-gray-400">
        게시글이 없습니다.
      </div>
      <div v-else>
        <div
          v-for="post in posts"
          :key="post.id"
          class="flex items-center justify-between border-b py-4 hover:bg-gray-50"
        >
          <PostItem :post="post" />
          <button
            @click="deletePost(post.id)"
            class="ml-4 rounded bg-red-500 px-3 py-1 text-white hover:bg-red-600"
          >
            삭제
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
interface Post {
  id: number;
  title: string;
  content: string;
  createdAt: string;
}

const {
  data: posts,
  pending: loading,
  refresh,
} = await useAsyncData(
  "posts",
  () => $fetch<Post[]>(`http://localhost:8080/api/posts`),
  {
    default: () => [],
  }
);

async function deletePost(id: number) {
  if (!confirm("정말 삭제하시겠습니까?")) return;

  try {
    await $fetch(`http://localhost:8080/api/posts/${id}`, {
      method: "DELETE",
    });
    refresh();
  } catch (err: any) {
    console.log("삭제 실패:", err);
    alert("삭제 중 오류가 발생했습니다.");
  }
}
</script>
